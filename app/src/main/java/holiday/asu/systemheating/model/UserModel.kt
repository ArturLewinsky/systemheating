package holiday.asu.systemheating.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class UserModel {

    constructor(name: String, temp: Float) {
        this.name = name
        this.temp = temp
    }

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String

    @SerializedName("temp")
    @Expose
    var temp: Float
}
