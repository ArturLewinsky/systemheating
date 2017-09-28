package holiday.asu.systemheating.di.testactivity

import dagger.Module
import dagger.Provides
import holiday.asu.systemheating.service.UserService
import holiday.asu.systemheating.MainActivity
import holiday.asu.systemheating.di.activity.testactivity.MainImplementation
import holiday.asu.systemheating.di.activity.testactivity.MainPresenter
import holiday.asu.systemheating.di.activity.testactivity.MainView
import holiday.asu.systemheating.di.network.ApiService


@Module
class MainActivityModule {
    @Provides
    fun provideMainView(mainActivity: MainActivity): MainView {
        return mainActivity
    }

    @Provides
    fun provideMainPresenter(mainView: MainView, apiService: ApiService): MainPresenter {
        return MainImplementation(mainView, apiService)
    }
}