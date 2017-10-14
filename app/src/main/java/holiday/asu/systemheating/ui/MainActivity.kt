package holiday.asu.systemheating.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.AndroidInjection
import holiday.asu.systemheating.R
import holiday.asu.systemheating.core.factory.ListViewModel
import javax.inject.Inject
import holiday.asu.systemheating.model.UserModel
import holiday.asu.systemheating.core.factory.ViewModelFactory
import holiday.asu.systemheating.model.UserAdapter
import holiday.asu.systemheating.ui.NavigationBottom.NavigationActivity
import holiday.asu.systemheating.utilly.BaseActivity
import holiday.asu.systemheating.utilly.DialogLoad

class MainActivity :  BaseActivity<ListViewModel>(), UserAdapter.UserClickListener {

    @Inject
    lateinit var mViewModelFactory: ViewModelFactory
    private lateinit var  mAdapter: UserAdapter
    val progressDialog = DialogLoad()
    lateinit var mUserList: ArrayList<UserModel>

    @BindView(R.id.recyclerView)
    lateinit var mRecyclerView: RecyclerView

    @BindView(R.id.button2)
    lateinit var mButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(MainActivity@this)
        AndroidInjection.inject(this)
        mUserList = ArrayList<UserModel>()
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(ListViewModel::class.java)
        observeLoadingStatus()
        observeResponse()
        configViews()

        mButton.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(applicationContext, NavigationActivity::class.java)
            startActivity(intent)
        })
    }

    private fun observeResponse() {
        mViewModel.getData().observe(this, Observer<List<UserModel>> { response -> processResponse(response) })
    }

    private fun processResponse(response: List<UserModel>?) {
        mUserList = response as ArrayList<UserModel>
        mAdapter.addUsers(response)
    }

    private fun observeLoadingStatus() {
        mViewModel.getLoadingStatus().observe(this, Observer{ loading -> isLoading(loading) })
    }

    private fun isLoading(loading: Boolean?) {
        if (loading!!)
            progressDialog.show(supportFragmentManager, "tag")
        else
            progressDialog.cancel()
    }

    private fun configViews() {
        this.mRecyclerView.recycledViewPool = RecyclerView.RecycledViewPool()
        this.mRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        this.mRecyclerView.setHasFixedSize(true)
        this.mRecyclerView.itemAnimator = DefaultItemAnimator()
        this.mAdapter = UserAdapter(this, layoutInflater)
        this.mRecyclerView.adapter = mAdapter
    }

    override fun onClick(position: Int, name: String) {

    }
}


