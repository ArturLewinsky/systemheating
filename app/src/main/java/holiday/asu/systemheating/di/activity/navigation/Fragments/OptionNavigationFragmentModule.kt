package holiday.asu.systemheating.di.activity.navigation.Fragments

import dagger.Module
import dagger.Provides
import holiday.asu.systemheating.ui.NavigationBottom.Fragments.OptionNavigationFragment
import javax.inject.Singleton

@Module
class OptionNavigationFragmentModule {
    @Singleton
    @Provides
    fun provideNavigationView( optionNavigationFragment: OptionNavigationFragment): OptionNavigationFragment {
        return optionNavigationFragment
    }
}