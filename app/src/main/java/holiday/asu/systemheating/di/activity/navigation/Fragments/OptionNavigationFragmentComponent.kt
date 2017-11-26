package holiday.asu.systemheating.di.activity.navigation.Fragments

import dagger.Subcomponent
import dagger.android.AndroidInjector
import holiday.asu.systemheating.ui.NavigationBottom.Fragments.OptionNavigationFragment

@Subcomponent(modules = arrayOf(OptionNavigationFragmentModule::class))
interface OptionNavigationFragmentComponent : AndroidInjector<OptionNavigationFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<OptionNavigationFragment>()
}