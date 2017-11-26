package holiday.asu.systemheating.core.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import holiday.asu.systemheating.service.UserService

class ViewTempModelFactory : ViewModelProvider.Factory {

    private var mServiceApi: UserService

    constructor(userService: UserService){
        mServiceApi = userService
    }
    override fun <T : ViewModel> create(modelClass: Class<T>): T? {
        return if (modelClass.isAssignableFrom(TempViewModel::class.java!!)) {
            TempViewModel(mServiceApi) as T
        } else null
    }
}