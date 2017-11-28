package holiday.asu.systemheating.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Temp {

    constructor(temp: Float) {
        this.temp = temp
    }

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("temp")
    @Expose
    var temp: Float
}