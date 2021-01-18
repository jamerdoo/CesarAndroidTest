package com.cesar.hiberustest.network

import com.cesar.hiberustest.domain.Resource
import com.cesar.hiberustest.domain.entity.MyDataResponse
import com.cesar.hiberustest.network.apiservice.DataApi
import com.cesar.hiberustest.utils.Logger
import com.cesar.hiberustest.utils.RestApi
import retrofit2.awaitResponse

class RetrofitProvider : Logger {

    override val nameClass: String get() = "--->" + javaClass.simpleName
    private val retrofit by lazy { RestApi.ServiceBuilder.buildService(DataApi::class.java) }

    suspend fun getData(): Resource<MyDataResponse> {
        val data = retrofit.getData().awaitResponse()
        return if (data.isSuccessful) {
            Resource.Success(data.body()!!)
        } else {
            Resource.Error(Throwable(""))
        }
    }



}