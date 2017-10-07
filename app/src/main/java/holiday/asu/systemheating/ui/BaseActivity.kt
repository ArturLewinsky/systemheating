package holiday.asu.systemheating.ui

import android.arch.lifecycle.LifecycleActivity
import android.support.design.widget.Snackbar
import android.arch.lifecycle.LifecycleFragment
import holiday.asu.systemheating.core.factory.BaseViewModel


abstract class BaseActivity<T : BaseViewModel<*>> : LifecycleActivity() {
    lateinit var mViewModel: T
}