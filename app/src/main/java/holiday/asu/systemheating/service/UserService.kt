package holiday.asu.systemheating.service

import holiday.asu.systemheating.model.Temp
import holiday.asu.systemheating.model.UserModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface UserService {
    @GET("/system/sensors")
    fun getUsers(): Observable<List<UserModel>>

    @GET("/system/temps")
    fun getTemp(): Observable<List<Temp>>

    @PUT("/system/tempchange")
    fun putTemp(@Body temp: Temp): Observable<Temp>
}