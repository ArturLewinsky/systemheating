package holiday.asu.systemheating.di.network

import dagger.Module
import dagger.Provides
import holiday.asu.asuholidays.service.UserService
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    @CustomScope
    fun usersService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }
}