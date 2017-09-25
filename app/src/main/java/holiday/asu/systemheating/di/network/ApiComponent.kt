package holiday.asu.asuholidays.di.network

import dagger.Component
import holiday.asu.systemheating.MainActivity
import holiday.asu.systemheating.di.network.ApiModule
import holiday.asu.systemheating.di.network.CustomScope
import holiday.asu.systemheating.di.network.NetworkComponent

@CustomScope
@Component(
        modules = arrayOf(ApiModule::class),
        dependencies = arrayOf (NetworkComponent::class))

interface ApiComponent {
    fun inject(activity: MainActivity)
}