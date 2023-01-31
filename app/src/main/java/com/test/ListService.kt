package com.test

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  15/12/2022
 */
interface ListService {
    @GET("550")
    suspend fun getListVideos(@Query("api_key") api_key: String): Response<ListModel>
}