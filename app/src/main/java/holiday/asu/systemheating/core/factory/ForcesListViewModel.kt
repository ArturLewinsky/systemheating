package holiday.asu.systemheating.core.factory

import holiday.asu.systemheating.model.UserModel
import holiday.asu.systemheating.service.UserService
import holiday.asu.systemheating.service.UserViewInterface
import io.reactivex.observers.DisposableObserver


class ForcesListViewModel : BaseViewModel {

    private var mServiceApi: UserService
    private var mViewInterface : UserViewInterface
    var mListUser: ArrayList<UserModel>

    constructor(serviceApi: UserService, userViewInterface: UserViewInterface) {
        this.mServiceApi = serviceApi
        this.mViewInterface = userViewInterface
        this.mListUser = ArrayList<UserModel>()
    }

    fun loadData() {
        subscribe(mViewInterface.getUsers(), object: DisposableObserver<List<UserModel>>() {
            override fun onComplete() {
                mViewInterface.onCompleted()
            }

            override fun onError(e: Throwable) {
                mViewInterface.onError(e.toString())
            }

            override fun onNext(userModel: List<UserModel> ) {
                mViewInterface.onUsers(userModel)
                mListUser = userModel as ArrayList<UserModel>
            }
        })
    }
}