package holiday.asu.systemheating.di.testactivity

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import holiday.asu.systemheating.ui.MainActivity

@Module
class MainActivityModule {
    @Singleton
    @Provides
    fun provideMainView(mainActivity: MainActivity): MainActivity {
        return mainActivity
    }
}