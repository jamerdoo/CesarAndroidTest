package com.cesar.hiberustest.network.apiservice

import com.cesar.hiberustest.domain.entity.MyDataResponse
import retrofit2.Call
import retrofit2.http.*

interface DataApi {

    @Headers("app-id: 6001e871aa08dbc9d85f6ec6")
    @GET("data/api/user")
    fun getData(): Call<MyDataResponse>
}