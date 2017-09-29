package holiday.asu.systemheating.core.factory

import io.reactivex.disposables.CompositeDisposable
import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

open class BaseViewModel : ViewModel{

    protected var mCompositeDisposable: CompositeDisposable

    constructor(){
        mCompositeDisposable = CompositeDisposable()
    }

    fun clearSubscriptions() {
        mCompositeDisposable.clear()
    }

    override fun onCleared() {
        clearSubscriptions()
    }

    protected fun <F> subscribe(observable: Observable<F>, observer: DisposableObserver<F>) {
        val subscription = observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(observer)
        configureSubscription()!!.add(subscription)
    }

    private fun configureSubscription(): CompositeDisposable? {
        if (mCompositeDisposable == null || mCompositeDisposable!!.isDisposed) {
            mCompositeDisposable = CompositeDisposable()
        }
        return this.mCompositeDisposable
    }
}