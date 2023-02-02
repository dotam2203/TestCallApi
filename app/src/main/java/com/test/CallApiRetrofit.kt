package com.test
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

object CallApiRetrofit {
    val BASE_URL = "https://api.themoviedb.org/3/movie/" //const
    private fun getApiUrl(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL).client(OkHttpClient().newBuilder().also { client ->
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                client.apply {
                    addNetworkInterceptor(loggingInterceptor)
                    connectTimeout(120, TimeUnit.SECONDS)
                    connectTimeout(120, TimeUnit.SECONDS)
                    protocols(Collections.singletonList(Protocol.HTTP_1_1))
                }
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    //khi nào được gọi thì Service mới được khởi tạo
    val loadApi: ListService by lazy {
        getApiUrl().create(ListService :: class.java)
    }
}