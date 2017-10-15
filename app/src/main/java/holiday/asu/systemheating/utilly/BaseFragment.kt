package holiday.asu.systemheating.utilly

import android.arch.lifecycle.LifecycleFragment
import holiday.asu.systemheating.core.factory.BaseViewModel

abstract class BaseFragment<T : BaseViewModel<*>> : LifecycleFragment() {
    lateinit var mViewModel: T
}