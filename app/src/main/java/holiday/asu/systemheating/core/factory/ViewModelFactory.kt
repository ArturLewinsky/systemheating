package holiday.asu.systemheating.core.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import holiday.asu.systemheating.service.UserService

class ViewModelFactory : ViewModelProvider.Factory {

    private var mServiceApi: UserService

    constructor(userService: UserService){
        mServiceApi = userService
    }
    override fun <T : ViewModel> create(modelClass: Class<T>): T? {
        return if (modelClass.isAssignableFrom(ListViewModel::class.java!!)) {
            ListViewModel(mServiceApi) as T
        } else null
    }
}