package holiday.asu.systemheating.utilly

import android.arch.lifecycle.LifecycleActivity
import holiday.asu.systemheating.core.factory.BaseViewModel


abstract class BaseActivity<T : BaseViewModel<*>> : LifecycleActivity() {
    lateinit var mViewModel: T
}