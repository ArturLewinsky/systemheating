package holiday.asu.systemheating.core.app

import android.app.Activity
import javax.inject.Inject
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector


class AndroidSampleApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()


    }



    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }
}