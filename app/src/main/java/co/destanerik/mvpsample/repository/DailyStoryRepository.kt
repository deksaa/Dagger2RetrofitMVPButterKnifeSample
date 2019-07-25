package co.destanerik.mvpsample.repository

import co.destanerik.mvpsample.api.ApiManager
import co.destanerik.mvpsample.model.DailyStory
import co.destanerik.mvpsample.service.DailyStoryService
import co.destanerik.mvpsample.service.ResponseCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DailyStoryRepository {

    fun getDailyStory(day: String, month: String, callback: ResponseCallback<DailyStory>)
    {
        ApiManager
            .create(DailyStoryService::class.java)
            .getDailyStory(month, day)
            .enqueue(object : Callback<DailyStory> {

            override fun onResponse(call: Call<DailyStory>?, response: Response<DailyStory>?)
            {
                if (response?.body() != null)
                    callback.onSuccess(call!!, response.body()!!)
            }

            override fun onFailure(call: Call<DailyStory>?, throwable: Throwable?)
            {
                if (throwable != null)
                    callback.onFailure(call!!, throwable)
            }
        })
    }
}