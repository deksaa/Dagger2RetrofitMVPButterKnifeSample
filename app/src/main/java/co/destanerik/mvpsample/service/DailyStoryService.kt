package co.destanerik.mvpsample.service

import co.destanerik.mvpsample.model.DailyStory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface DailyStoryService {

    @Headers("Content-Type: application/json")
    @GET("{month}/{day}/date")
    fun getDailyStory(@Path("month") month: String, @Path("day") day: String): Call<DailyStory>

}