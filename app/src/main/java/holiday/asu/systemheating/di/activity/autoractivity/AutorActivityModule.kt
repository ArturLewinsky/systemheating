package holiday.asu.systemheating.di.activity.autoractivity

import dagger.Module
import dagger.Provides
import holiday.asu.systemheating.ui.Autor.Activity.AutorActivity
import javax.inject.Singleton

@Module
class AutorActivityModule {
    @Singleton
    @Provides
    fun provideNavigationView(autorActivity: AutorActivity): AutorActivity {
        return autorActivity
    }
}