package holiday.asu.systemheating

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.android.support.AndroidSupportInjection
import holiday.asu.systemheating.di.activity.testactivity.MainView
import holiday.asu.systemheating.service.UserService
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {


    @Inject
    lateinit var mService : UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidSupportInjection.inject(this)
    }

    override fun onMainLoaded() {

    }
}
