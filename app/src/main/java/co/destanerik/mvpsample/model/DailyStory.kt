package co.destanerik.mvpsample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DailyStory {

    @SerializedName("text")
    @Expose
    var text: String? = null
    @SerializedName("year")
    @Expose
    var year: Int? = null
    @SerializedName("number")
    @Expose
    var number: Int? = null
    @SerializedName("found")
    @Expose
    var found: Boolean? = null
    @SerializedName("type")
    @Expose
    var type: String? = null

}