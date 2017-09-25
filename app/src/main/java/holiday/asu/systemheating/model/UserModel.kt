package holiday.asu.systemheating.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class UserModel {

    constructor(name: String?, surrname: String?, title: String?, favorite: Boolean) {
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
    var name: String? = null

    @SerializedName("surrname")
    @Expose
    var surrname: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("favorite")
    @Expose
    var favorite: Boolean? = null
}
