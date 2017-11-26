package holiday.asu.systemheating.core.di.module

import dagger.Module
import android.app.Application
import android.content.Context
import javax.inject.Singleton
import dagger.Provides
import holiday.asu.systemheating.core.factory.ViewModelFactory
import holiday.asu.systemheating.core.factory.ViewTempModelFactory
import holiday.asu.systemheating.di.activity.testactivity.MainActivityComponent
import holiday.asu.systemheating.service.UserService

@Module(subcomponents = arrayOf(
        MainActivityComponent::class
))

class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideViewModelFactory(userService: UserService): ViewModelFactory {
        return ViewModelFactory(userService)
    }

    @Provides
    fun provideViewTempModelFactory(userService: UserService): ViewTempModelFactory {
        return ViewTempModelFactory(userService)
    }
}