package holiday.asu.systemheating.di.activity.navigation.Fragments

import dagger.Module
import dagger.Provides
import holiday.asu.systemheating.ui.NavigationBottom.MainNavigationFragment
import javax.inject.Singleton

@Module
class MainNavigationFragmentModule {
    @Singleton
    @Provides
    fun provideNavigationView( mainNavigationFragment: MainNavigationFragment): MainNavigationFragment {
        return mainNavigationFragment
    }
}