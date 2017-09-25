package holiday.asu.systemheating.service

import holiday.asu.systemheating.model.UserModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {
    @GET("/users")
    fun getUsers(): Observable<List<UserModel>>

    @POST("user/")
    fun createUser(@Body user: UserModel): Call<UserModel>
}