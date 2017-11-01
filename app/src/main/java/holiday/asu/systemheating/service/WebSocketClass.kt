package holiday.asu.systemheating.service

import okhttp3.WebSocketListener
import okhttp3.WebSocket

class WebSocketClass: WebSocketListener() {

    fun onOpen(webSocket: WebSocket, response: Response<*>) {
        webSocket.send("Hello, it's SSaurel !")
        webSocket.send("What's up ?")
        webSocket.close(NORMAL_CLOSURE_STATUS, "Goodbye !")
    }

    companion object {
        private val NORMAL_CLOSURE_STATUS = 1000
    }

}