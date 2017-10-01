package holiday.asu.systemheating.core.factory

import io.reactivex.observers.DisposableObserver
import holiday.asu.systemheating.service.ServiceResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import holiday.asu.systemheating.model.UserModel
import holiday.asu.systemheating.service.UserService
import holiday.asu.systemheating.service.UserViewInterface
import io.reactivex.Observable

class ForcesListViewModel : BaseViewModel<List<UserModel>> {

    private var mServiceApi: UserService
    private var mViewInterface : UserViewInterface
    var mListArray: ArrayList<UserModel>

    constructor(ServiceApi: UserService, viewInterface: UserViewInterface) : super() {
        this.mServiceApi = ServiceApi
        this.mViewInterface = viewInterface
        this.mListArray = ArrayList<UserModel>()
    }

    fun fetchUsers() {
        clearSubscriptions()
        subscribe(mViewInterface.getUsers(), object: DisposableObserver<List<UserModel>>() {
            override fun onComplete() {
                mViewInterface.onCompleted()
            }

            override fun onError(e: Throwable) {
                mViewInterface.onError(e.toString())
            }

            override fun onNext(userModel: List<UserModel> ) {
                mViewInterface.onUsers(userModel)
                mListArray = userModel as ArrayList<UserModel>
                mData.setValue(ServiceResult(userModel))
            }
        })
    }
    protected fun <F> subscribe(observable: Observable<F>, observer: DisposableObserver<F>) {
        val subscription = observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(observer)
        configureSubscription()!!.add(subscription)
    }
}