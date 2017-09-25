package holiday.asu.systemheating.core.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import holiday.asu.asuholidays.core.app.AndroidSampleApp
import holiday.asu.systemheating.core.di.builder.ActivityBuilder
import holiday.asu.systemheating.di.network.ApiModule
import holiday.asu.systemheating.di.network.AppModule
import holiday.asu.systemheating.di.network.NetworkComponent
import holiday.asu.systemheating.di.network.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class,
        ApiModule::class),
        dependencies = arrayOf (
                NetworkComponent::class)
)

interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun networkModule(module: NetworkModule): Builder
        fun networkComponent(component: NetworkComponent): Builder
        fun build(): AppComponent
    }

    fun inject(app: AndroidSampleApp)
}