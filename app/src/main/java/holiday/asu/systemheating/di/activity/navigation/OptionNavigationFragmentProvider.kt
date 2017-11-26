package holiday.asu.systemheating.di.activity.navigation

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import holiday.asu.systemheating.di.activity.navigation.Fragments.OptionNavigationFragmentComponent
import holiday.asu.systemheating.ui.NavigationBottom.Fragments.OptionNavigationFragment

@Module
abstract class OptionNavigationFragmentProvider {
    @Binds
    @IntoMap
    @FragmentKey(OptionNavigationFragment::class)
    internal abstract fun provideOptionNavigationFragmentFactory(builder: OptionNavigationFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>
}