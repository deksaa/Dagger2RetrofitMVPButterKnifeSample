package co.destanerik.mvpsample.api

import co.destanerik.mvpsample.constants.ApiEndPoints
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.google.gson.GsonBuilder

class ApiManager {

    companion object {

        private var interceptor: HttpLoggingInterceptor? = null
        private var httpClient: OkHttpClient? = null

        private var retrofit: Retrofit? = null


        fun <T> create(retroClass: Class<T>): T {

            if (retrofit == null)
            {
                interceptor = HttpLoggingInterceptor()
                interceptor?.level = HttpLoggingInterceptor.Level.BODY

                httpClient = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(5, TimeUnit.MINUTES)
                    .readTimeout(5, TimeUnit.MINUTES)
                    .writeTimeout(5, TimeUnit.MINUTES)
                    .build()

                val gson = GsonBuilder().setLenient().create()

                retrofit = Retrofit.Builder()
                    .client(httpClient)
                    .baseUrl(ApiEndPoints.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }

            return retrofit!!.create(retroClass)
        }

    }
}