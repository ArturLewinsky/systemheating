package holiday.asu.systemheating.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.android.AndroidInjection
import holiday.asu.systemheating.R
import holiday.asu.systemheating.core.factory.ForcesListViewModel
import holiday.asu.systemheating.service.UserService
import javax.inject.Inject
import holiday.asu.systemheating.model.UserModel
import holiday.asu.systemheating.service.UserViewInterface
import io.reactivex.Observable
import android.arch.lifecycle.ViewModelProviders


import holiday.asu.systemheating.core.factory.ViewModelFactory




class MainActivity : AppCompatActivity(), UserViewInterface {

    @Inject
    lateinit var mService: UserService

    lateinit var mViewModel: ForcesListViewModel
  
    @Inject
    lateinit var mViewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        mViewModel = ViewModelProviders.of(this).get(ForcesListViewModel::class.java)

    }



    override fun getUsers(): Observable<List<UserModel>> {
        return this.mService.getUsers()
    }

    override fun onUsers(usersModel: List<UserModel>) {

    }

    override fun onError(message: String) {
    }

    override fun onCompleted() {
    }

    override fun onResume() {
        super.onResume()

    }
}
