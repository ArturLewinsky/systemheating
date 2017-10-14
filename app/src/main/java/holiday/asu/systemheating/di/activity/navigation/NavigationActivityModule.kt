package holiday.asu.systemheating.di.activity.navigation

import dagger.Module
import dagger.Provides
import holiday.asu.systemheating.ui.MainActivity
import holiday.asu.systemheating.ui.NavigationBottom.NavigationActivity
import javax.inject.Singleton

@Module
class NavigationActivityModule {
    @Singleton
    @Provides
    fun provideNavigationView(navigationActivity: NavigationActivity): NavigationActivity {
        return navigationActivity
    }
}