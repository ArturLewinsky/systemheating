package holiday.asu.systemheating.di.activity.testactivity

import holiday.asu.systemheating.di.network.ApiService
import javax.inject.Inject



/**
 * Created by Artur on 27.09.2017.
 */
class MainImplementation : MainPresenter{

    var mainView: MainView
    var apiService: ApiService

    @Inject
    constructor(mainView: MainView, apiService: ApiService) {
        this.mainView = mainView
        this.apiService = apiService
    }

    override fun loadMain() {
        apiService.loadData()
        mainView.onMainLoaded()
    }
}