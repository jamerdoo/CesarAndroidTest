package com.cesar.hiberustest.domain.repository

import com.cesar.hiberustest.domain.Resource
import com.cesar.hiberustest.domain.entity.MyDataResponse

class InfoRepository(val infoDataSource: InfoDataSource) {

    suspend fun getInfo() : Resource<MyDataResponse> = infoDataSource.getInfo()
}