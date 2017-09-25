package holiday.asu.systemheating.base

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class BasePresenter : Presenter {

    private var mCompositeSubscription: CompositeDisposable? = null

    override fun onCreate() {}

    override fun onPause() {

    }

    override fun onResume() {
        configureSubscription()
    }

    private fun configureSubscription(): CompositeDisposable? {
        if (mCompositeSubscription == null || mCompositeSubscription!!.isDisposed) {
            mCompositeSubscription = CompositeDisposable()
        }
        return this.mCompositeSubscription
    }

    override fun onDestroy() {
        unSubscribeAll()
    }

    protected fun unSubscribeAll() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription!!.dispose()
            mCompositeSubscription!!.clear()
        }
    }

    protected fun <F> subscribe(observable: Observable<F>, observer: DisposableObserver<F>) {

        val subscription = observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(observer)
        configureSubscription()!!.add(subscription)
    }
}