package holiday.asu.systemheating.core.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import holiday.asu.systemheating.di.activity.autoractivity.AutorActivityModule
import holiday.asu.systemheating.di.activity.navigation.Fragments.MainNavigationFragmentModule
import holiday.asu.systemheating.di.activity.navigation.Fragments.OptionNavigationFragmentModule
import holiday.asu.systemheating.di.activity.navigation.NavigationActivityModule
import holiday.asu.systemheating.di.testactivity.MainActivityModule
import holiday.asu.systemheating.ui.Autor.Activity.AutorActivity
import holiday.asu.systemheating.ui.MainActivity
import holiday.asu.systemheating.ui.NavigationBottom.Fragments.MainNavigationFragment
import holiday.asu.systemheating.ui.NavigationBottom.Activity.NavigationActivity
import holiday.asu.systemheating.ui.NavigationBottom.Fragments.OptionNavigationFragment

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = arrayOf(NavigationActivityModule::class))
    abstract fun bindNavigationActivity(): NavigationActivity

    @ContributesAndroidInjector(modules = arrayOf(MainNavigationFragmentModule::class))
    abstract fun bindMainNavigationFragment(): MainNavigationFragment

    @ContributesAndroidInjector(modules = arrayOf(OptionNavigationFragmentModule::class))
    abstract fun bindOptionNavigationFragment(): OptionNavigationFragment

    @ContributesAndroidInjector(modules = arrayOf(AutorActivityModule::class))
    abstract fun bindAutorActivity(): AutorActivity
}