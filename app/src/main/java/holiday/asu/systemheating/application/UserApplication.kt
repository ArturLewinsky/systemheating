package holiday.asu.systemheating.application

import android.app.Application
import holiday.asu.asuholidays.di.network.*
import holiday.asu.systemheating.di.network.NetworkComponent


class UserApplication : Application(){


    private lateinit var mApiComponent: ApiComponent

    override fun onCreate() {
      //  resolveDependency()
        super.onCreate()
    }



    fun getApiComponent(): ApiComponent {
        return mApiComponent
    }
}