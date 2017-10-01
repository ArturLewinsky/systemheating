package holiday.asu.systemheating.di.testactivity

import dagger.Subcomponent
import dagger.android.AndroidInjector
import holiday.asu.systemheating.ui.MainActivity


@Subcomponent(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}