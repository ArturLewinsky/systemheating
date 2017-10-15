package holiday.asu.systemheating.di.activity.navigation

import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import dagger.Binds
import dagger.Module
import dagger.android.support.FragmentKey
import holiday.asu.systemheating.di.activity.navigation.Fragments.MainNavigationFragmentComponent
import holiday.asu.systemheating.ui.NavigationBottom.Fragments.MainNavigationFragment


@Module
abstract class MainNavigationFragmentProvider {
    @Binds
    @IntoMap
    @FragmentKey(MainNavigationFragment::class)
    internal abstract fun provideDetailFragmentFactory(builder: MainNavigationFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>
}