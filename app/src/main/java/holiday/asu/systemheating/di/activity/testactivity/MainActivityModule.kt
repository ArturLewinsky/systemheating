package holiday.asu.systemheating.di.testactivity

import dagger.Module
import dagger.Provides
import holiday.asu.systemheating.MainActivity
import holiday.asu.systemheating.core.factory.ViewModelFactory
import holiday.asu.systemheating.service.UserService
import holiday.asu.systemheating.service.UserViewInterface


@Module
class MainActivityModule {
    @Provides
    fun provideMainView(mainActivity: MainActivity): MainActivity {
        return mainActivity
    }

    @Provides
    fun provideViewModelFactory(userService: UserService, userViewInterface: UserViewInterface): ViewModelFactory {
        return ViewModelFactory(userService, userViewInterface)
    }
}