package holiday.asu.systemheating.core.factory
import android.arch.lifecycle.ViewModel
import holiday.asu.systemheating.service.UserService
import holiday.asu.systemheating.service.UserViewInterface

class ViewModelFactory {

    private var mServiceApi: UserService
    private var mViewInterface : UserViewInterface

    constructor(userService: UserService, userViewInterface: UserViewInterface){
        mServiceApi = userService
        this.mViewInterface = userViewInterface
    }
    fun <T : ViewModel> create(modelClass: Class<T>): T? {
        return if (modelClass.isAssignableFrom(ForcesListViewModel::class.java!!)) {
            ForcesListViewModel(mServiceApi, mViewInterface) as T
        } else null
    }
}