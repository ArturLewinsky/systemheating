package holiday.asu.systemheating.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.AndroidInjection
import holiday.asu.systemheating.R
import holiday.asu.systemheating.core.factory.ForcesListViewModel
import javax.inject.Inject
import holiday.asu.systemheating.model.UserModel
import holiday.asu.systemheating.service.ServiceResult
import holiday.asu.systemheating.core.factory.ViewModelFactory
import holiday.asu.systemheating.model.UserAdapter

class MainActivity :  BaseActivity<ForcesListViewModel>(), UserAdapter.UserClickListener {

    @Inject
    lateinit var mViewModelFactory: ViewModelFactory
    private lateinit var  mAdapter: UserAdapter
    @BindView(R.id.recyclerView)
    lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(MainActivity@this)
        dependency()
        configViews()

    }

    fun loadData(res: ServiceResult<List<UserModel>>) {
        if (res.isSuccessful)
            res.result.toString()
    }

    fun dependency() {
        AndroidInjection.inject(this)
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(ForcesListViewModel::class.java)
        mViewModel.getData().observe(this, Observer {observer: ServiceResult<List<UserModel>>? ->
            if (observer != null) {
                this.loadData(observer)
            }
        })
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


