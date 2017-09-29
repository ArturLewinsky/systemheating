package holiday.asu.systemheating.di.network

import dagger.Module
import holiday.asu.systemheating.di.testactivity.MainActivityComponent
import android.app.Application
import android.content.Context
import javax.inject.Singleton
import dagger.Provides

@Module(subcomponents = arrayOf(
        MainActivityComponent::class
))

class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}