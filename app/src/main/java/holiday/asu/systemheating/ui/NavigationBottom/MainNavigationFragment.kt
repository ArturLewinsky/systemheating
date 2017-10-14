package holiday.asu.systemheating.ui.NavigationBottom

import android.arch.lifecycle.LifecycleFragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import holiday.asu.systemheating.R
import dagger.android.support.AndroidSupportInjection



class MainNavigationFragment : LifecycleFragment() {

    companion object {
        fun newInstance() = MainNavigationFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        initViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main_navigation, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initViewModel() {

    }

    private fun initUI() {

    }

}