package holiday.asu.systemheating.ui.NavigationBottom.Fragments

import android.arch.lifecycle.LifecycleFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import holiday.asu.systemheating.R
import holiday.asu.systemheating.service.WebSocketClass
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket



class OptionNavigationFragment : LifecycleFragment() {

    private lateinit var client: OkHttpClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        initViewModel()
        client = OkHttpClient()
        start()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main_navigation, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initViewModel() {

    }

    private fun initUI() {

    }

    private fun start() {
        val request = Request.Builder().url("ws://dark-goosebumps-51151.herokuapp.com/ws/files").build()
        val listener = WebSocketClass()
        val ws = client.newWebSocket(request, listener)
        client.dispatcher().executorService().shutdown()
    }
}