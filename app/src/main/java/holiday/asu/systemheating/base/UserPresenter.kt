package holiday.asu.systemheating.base

import holiday.asu.asuholidays.service.UserViewInterface
import holiday.asu.systemheating.model.UserModel
import io.reactivex.observers.DisposableObserver

class UserPresenter : BasePresenter{

    private var mViewInterface : UserViewInterface
    var mListUser: ArrayList<UserModel>

    constructor(userViewInterface: UserViewInterface) {
        this.mViewInterface = userViewInterface
        this.mListUser = ArrayList<UserModel>()
    }

    fun fetchUsers() {
        unSubscribeAll()
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