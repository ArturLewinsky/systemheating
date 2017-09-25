package holiday.asu.systemheating.service

import holiday.asu.systemheating.model.UserModel
import io.reactivex.Observable

interface UserViewInterface  {
    fun onCompleted()

    fun onError(message: String)

    fun onUsers(usersModel: List<UserModel>)

    fun getUsers(): Observable<List<UserModel>>
}