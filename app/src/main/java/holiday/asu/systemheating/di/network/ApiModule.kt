package holiday.asu.systemheating.di.network

import dagger.Module
import dagger.Provides
import holiday.asu.systemheating.service.UserService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun usersService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }
}