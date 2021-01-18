package com.cesar.hiberustest.domain.repository

import com.cesar.hiberustest.domain.Resource
import com.cesar.hiberustest.domain.entity.MyDataResponse


interface InfoDataSource {

    suspend fun getInfo(): Resource<MyDataResponse>
}