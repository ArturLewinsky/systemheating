package holiday.asu.systemheating.service

import holiday.asu.systemheating.model.Temp
import holiday.asu.systemheating.model.UserModel
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT

interface UserService {
    @GET("/Holidays/sensors")
    fun getUsers(): Observable<List<UserModel>>

    @GET("/Holidays/temps")
    fun getTemp(): Observable<List<Temp>>

    @PUT("/Holidays/edit_temp")
    fun putTemp(@Body temp: Temp): Observable<Temp>
}