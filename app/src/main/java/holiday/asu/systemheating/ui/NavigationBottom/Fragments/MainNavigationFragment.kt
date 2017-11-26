package holiday.asu.systemheating.ui.NavigationBottom.Fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import holiday.asu.systemheating.R
import dagger.android.support.AndroidSupportInjection
import holiday.asu.systemheating.core.factory.ListViewModel
import holiday.asu.systemheating.core.factory.ViewModelFactory
import holiday.asu.systemheating.model.UserAdapter
import holiday.asu.systemheating.model.UserModel
import holiday.asu.systemheating.utilly.BaseFragment
import holiday.asu.systemheating.utilly.DialogLoad
import javax.inject.Inject

class MainNavigationFragment : BaseFragment<ListViewModel>(), UserAdapter.UserClickListener {

    @Inject
    lateinit var mViewModelFactory: ViewModelFactory
    private lateinit var  mAdapter: UserAdapter
    val progressDialog = DialogLoad()
    lateinit var mUserList: ArrayList<UserModel>

    @BindView(R.id.recyclerViewMain)
    lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        initViewModel()
        mUserList = ArrayList<UserModel>()

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater?.inflate(R.layout.fragment_main_navigation, container, false)!!
        ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configViews()
    }

    private fun initViewModel() {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(ListViewModel::class.java)
        observeLoadingStatus()
        observeResponse()
    }

    private fun observeResponse() {
        mViewModel.getData().observe(this, Observer<List<UserModel>> { response -> processResponse(response) })
    }

    private fun observeLoadingStatus() {
        mViewModel.getLoadingStatus().observe(this, Observer{ loading -> isLoading(loading) })
    }

    private fun processResponse(response: List<UserModel>?) {
        mUserList = response as ArrayList<UserModel>
        mAdapter.addUsers(response)
    }

    private fun isLoading(loading: Boolean?) {
        if (loading!!)
            progressDialog.show(childFragmentManager, "tag")
        else
            progressDialog.cancel()
    }

    private fun configViews() {
        this.mRecyclerView.recycledViewPool = RecyclerView.RecycledViewPool()
        this.mRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        this.mRecyclerView.setHasFixedSize(true)
        this.mRecyclerView.itemAnimator = DefaultItemAnimator()
        this.mAdapter = UserAdapter(this, layoutInflater)
        this.mRecyclerView.adapter = mAdapter
    }

    override fun onClick(position: Int, name: String) {

    }
}