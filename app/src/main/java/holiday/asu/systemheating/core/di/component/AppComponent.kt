package holiday.asu.systemheating.core.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import holiday.asu.systemheating.core.app.AndroidSampleApp
import holiday.asu.systemheating.core.di.builder.ActivityBuilder
import holiday.asu.systemheating.di.network.ApiModule
import holiday.asu.systemheating.di.network.AppModule
import holiday.asu.systemheating.di.network.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class,
        NetworkModule::class,
        ApiModule::class))

interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
        fun apiModule(apiModule: ApiModule): Builder
    }

    fun inject(app: AndroidSampleApp)
}