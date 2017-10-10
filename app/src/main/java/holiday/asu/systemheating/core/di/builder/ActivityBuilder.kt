package holiday.asu.systemheating.core.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import holiday.asu.systemheating.di.testactivity.MainActivityModule
import holiday.asu.systemheating.ui.MainActivity

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}