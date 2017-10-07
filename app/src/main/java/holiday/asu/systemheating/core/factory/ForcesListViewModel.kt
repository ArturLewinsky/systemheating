package holiday.asu.systemheating.core.factory


import holiday.asu.systemheating.model.UserModel
import holiday.asu.systemheating.service.ServiceResult
import holiday.asu.systemheating.service.UserService
import holiday.asu.systemheating.service.UserViewInterface
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


class ForcesListViewModel : BaseViewModel<List<UserModel>>, UserViewInterface {

    private var mServiceApi: UserService
    var mListArray: ArrayList<UserModel>

    constructor(ServiceApi: UserService) : super() {
        this.mServiceApi = ServiceApi
        this.mListArray = ArrayList<UserModel>()
    }

    override fun getUsers(): Observable<List<UserModel>> {
        return mServiceApi.getUsers()
    }

    override fun onUsers(usersModel: List<UserModel>) {
    }

    override fun onError(message: String) {
    }

    override fun onCompleted() {
    }

    fun loadData() {
        clearSubscriptions()
        subscribe(getUsers(), object: DisposableObserver<List<UserModel>>() {
            override fun onComplete() {
                onCompleted()
            }

            override fun onError(e: Throwable) {
                onError(e.toString())
            }

            override fun onNext(userModel: List<UserModel> ) {
                onUsers(userModel)
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