package holiday.asu.systemheating.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class UserModel {

    constructor(name: String, surrname: String, title: String, favorite: Boolean) {
        this.name = name
        this.surrname = surrname
        this.title = title
        this.favorite = favorite
    }

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String

    @SerializedName("surrname")
    @Expose
    var surrname: String

    @SerializedName("title")
    @Expose
    var title: String

    @SerializedName("favorite")
    @Expose
    var favorite: Boolean
}
