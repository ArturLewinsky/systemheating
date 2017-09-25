package holiday.asu.systemheating.di.network

import dagger.Module
import holiday.asu.systemheating.di.testactivity.MainActivityComponent


@Module(subcomponents = arrayOf(
        MainActivityComponent::class
))

class AppModule {

}