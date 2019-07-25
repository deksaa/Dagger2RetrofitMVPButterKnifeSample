package co.destanerik.mvpsample.service


import retrofit2.Call
import retrofit2.Response

interface ResponseCallback<T> {

    fun onSuccess(call: Call<T>, response: T)

    fun onFailure(call: Call<T>, t: Throwable)
}