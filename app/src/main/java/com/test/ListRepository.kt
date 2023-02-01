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
        //thực hiện gọi API bằng retrofit
        val request = CallApiRetrofit.loadApi.getItem(api_key)
        if(request.isSuccessful)
            //phát kết quả yêu cầu cho luồng flow
            emit(request)
    }.flowOn(IO)// chạy trong IO được ưu tiên
}