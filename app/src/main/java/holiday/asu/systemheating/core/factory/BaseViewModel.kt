package holiday.asu.systemheating.core.factory

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import android.arch.lifecycle.ViewModel

open class BaseViewModel<T> : ViewModel{

    protected var mData = MutableLiveData<T>()
    protected var mLoading = MutableLiveData<Boolean>()
    protected var mCompositeDisposable: CompositeDisposable

    constructor(){
        mCompositeDisposable = CompositeDisposable()
    }

    fun getData() : LiveData<T> {

        return mData
    }

    fun getLoadingStatus() : LiveData<Boolean> {
        return mLoading
    }

    fun clearSubscriptions() {
        mCompositeDisposable.clear()
    }

    override fun onCleared() {
        clearSubscriptions()
    }
}