package holiday.asu.systemheating.core.factory

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import android.arch.lifecycle.ViewModel
import holiday.asu.systemheating.service.ServiceResult


open class BaseViewModel<T> : ViewModel{

    protected var mData = MutableLiveData<ServiceResult<T>>()
    protected var mCompositeDisposable: CompositeDisposable

    constructor(){
        mCompositeDisposable = CompositeDisposable()
    }

    fun getData() : LiveData<ServiceResult<T>> {
        return mData
    }

    fun clearSubscriptions() {
        mCompositeDisposable.clear()
    }

    override fun onCleared() {
        clearSubscriptions()
    }

    protected fun configureSubscription(): CompositeDisposable? {
        if (mCompositeDisposable == null || mCompositeDisposable!!.isDisposed) {
            mCompositeDisposable = CompositeDisposable()
        }
        return this.mCompositeDisposable
    }
}