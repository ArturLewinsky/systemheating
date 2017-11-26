package holiday.asu.systemheating.service

import android.widget.Toast
import okhttp3.Response
import okhttp3.WebSocketListener
import okhttp3.WebSocket

class WebSocketClass: WebSocketListener {

    private val NORMAL_CLOSURE_STATUS = 1000

    var message: String
    constructor(message: String) {
        this.message = message
    }

    override fun onOpen(webSocket: WebSocket?, response: Response?) {
        webSocket!!.send(this.message)

        webSocket.close(NORMAL_CLOSURE_STATUS, "message")
    }

    override fun onFailure(webSocket: WebSocket?, t: Throwable?, response: Response?) {
        t.toString()
    }
}