package holiday.asu.systemheating.di.FactoryModule

import dagger.Module
import dagger.Provides
import holiday.asu.systemheating.core.factory.ViewModelFactory
import holiday.asu.systemheating.service.UserService
import holiday.asu.systemheating.service.UserViewInterface

@Module
class ForcesListModule {
    @Provides
    fun provideViewModelFactory(serviceApi: UserService, userViewInterface: UserViewInterface): ViewModelFactory {
        return ViewModelFactory(serviceApi, userViewInterface)
    }
}
