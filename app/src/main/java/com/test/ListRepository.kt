package com.test

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response


/**
 * Author: tamdt35@fpt.com.vn
 * Date:  15/12/2022
 */
class ListRepository {
    fun getShowItem(api_key: String): Flow<Response<ListModel>> = flow{
        val request = CallApiRetrofit.loadApi.getItem(api_key)
        if(request.isSuccessful)
            emit(request)
    }.flowOn(IO)
    fun getShowList(api_key: String) : Flow<Response<List<Genres>>> = flow {
        val request =  CallApiRetrofit.loadApi.getListVideos(api_key)
        if(request.isSuccessful)
            emit(request)
    }.flowOn(IO)
}