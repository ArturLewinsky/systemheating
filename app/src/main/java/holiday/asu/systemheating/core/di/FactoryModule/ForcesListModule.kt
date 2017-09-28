package holiday.asu.systemheating.core.factory

import dagger.Module
import dagger.Provides
import holiday.asu.systemheating.service.UserService


@Module
class ForcesListModule {
    @Provides
    fun provideViewModelFactory(serviceApi: UserService): ViewModelFactory {
        return ViewModelFactory(serviceApi)
    }
}
