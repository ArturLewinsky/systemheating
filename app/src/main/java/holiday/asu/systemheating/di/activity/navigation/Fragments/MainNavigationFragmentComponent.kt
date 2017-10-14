package holiday.asu.systemheating.di.activity.navigation.Fragments

import dagger.Subcomponent
import dagger.android.AndroidInjector
import holiday.asu.systemheating.ui.NavigationBottom.MainNavigationFragment

@Subcomponent(modules = arrayOf(MainNavigationFragmentModule::class))
interface MainNavigationFragmentComponent : AndroidInjector<MainNavigationFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainNavigationFragment>()
}