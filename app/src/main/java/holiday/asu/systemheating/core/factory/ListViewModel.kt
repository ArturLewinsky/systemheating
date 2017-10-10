package holiday.asu.systemheating.core.factory

import holiday.asu.systemheating.model.UserModel
import holiday.asu.systemheating.service.UserService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListViewModel : BaseViewModel<List<UserModel>>{

    private var mServiceApi: UserService

    constructor(ServiceApi: UserService) : super() {
        this.mServiceApi = ServiceApi
        loadAsu(mServiceApi.getUsers())
    }

    private fun loadAsu(observable: Observable<List<UserModel>>) {
        mCompositeDisposable.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe({ s -> mLoading.setValue(true) })
                .doAfterTerminate({ mLoading.setValue(false) })
                .subscribe(
                        { greeting -> mData.setValue(greeting) }
                )
        )
    }
}