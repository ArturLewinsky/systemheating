package holiday.asu.systemheating.di.activity.autoractivity

import dagger.Subcomponent
import dagger.android.AndroidInjector
import holiday.asu.systemheating.ui.Autor.Activity.AutorActivity

@Subcomponent(modules = arrayOf(AutorActivityModule::class))
interface AutorActivityComponent : AndroidInjector<AutorActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<AutorActivity>()
}