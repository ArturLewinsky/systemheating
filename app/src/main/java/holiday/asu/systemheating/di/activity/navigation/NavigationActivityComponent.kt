package holiday.asu.systemheating.di.activity.navigation

import dagger.Subcomponent
import dagger.android.AndroidInjector
import holiday.asu.systemheating.ui.NavigationBottom.Activity.NavigationActivity

@Subcomponent(modules = arrayOf(NavigationActivityModule::class, MainNavigationFragmentProvider::class))
interface NavigationActivityComponent : AndroidInjector<NavigationActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<NavigationActivity>()
}