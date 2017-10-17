package holiday.asu.systemheating.utilly


import android.arch.lifecycle.LifecycleOwner
import android.support.v4.app.Fragment
import holiday.asu.systemheating.core.factory.BaseViewModel

abstract class BaseFragment<T : BaseViewModel<*>> : Fragment(), LifecycleOwner {
    lateinit var mViewModel: T
}