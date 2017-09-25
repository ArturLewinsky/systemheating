package holiday.asu.asuholidays.core.app

import android.app.Activity
import javax.inject.Inject
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import holiday.asu.systemheating.core.di.component.DaggerAppComponent
import holiday.asu.systemheating.di.network.DaggerNetworkComponent
import holiday.asu.systemheating.di.network.NetworkComponent
import holiday.asu.systemheating.di.network.NetworkModule
import holiday.asu.systemheating.model.Constant

class AndroidSampleApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)

    }

    fun getNetworkComponent(): NetworkComponent {
        return DaggerNetworkComponent
                .builder()
                .networkModule(NetworkModule(Constant.BASE_URL))
                .build()
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }
}