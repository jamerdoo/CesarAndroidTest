package com.cesar.hiberustest.network

import com.cesar.hiberustest.domain.Resource
import com.cesar.hiberustest.domain.entity.MyDataResponse
import com.cesar.hiberustest.domain.repository.InfoDataSource


class InfoDataSourceImpl(private val retrofitProvider: RetrofitProvider) : InfoDataSource {

    override suspend fun getInfo(): Resource<MyDataResponse> {
        return retrofitProvider.getData()
    }
}