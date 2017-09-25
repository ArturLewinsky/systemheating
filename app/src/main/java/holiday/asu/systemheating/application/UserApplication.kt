package holiday.asu.systemheating.application

import android.app.Application
import holiday.asu.asuholidays.di.network.*
import holiday.asu.systemheating.di.network.DaggerNetworkComponent
import holiday.asu.systemheating.di.network.NetworkComponent
import holiday.asu.systemheating.di.network.NetworkModule
import holiday.asu.systemheating.model.Constant


class UserApplication : Application(){


    private lateinit var mApiComponent: ApiComponent

    override fun onCreate() {
        resolveDependency()
        super.onCreate()
    }

    private fun resolveDependency() {
        mApiComponent = DaggerApiComponent
                .builder()
                .networkComponent(getNetworkComponent())
                .build()
    }

    fun getNetworkComponent(): NetworkComponent {
        return DaggerNetworkComponent
                .builder()
                .networkModule(NetworkModule(Constant.BASE_URL))
                .build()
    }

    fun getApiComponent(): ApiComponent {
        return mApiComponent
    }
}