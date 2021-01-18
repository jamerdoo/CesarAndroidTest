package com.cesar.hiberustest.domain.usercase


import com.cesar.hiberustest.domain.Resource
import com.cesar.hiberustest.domain.entity.MyDataResponse
import com.cesar.hiberustest.domain.repository.InfoRepository

class GetInfo(private val infoRepository: InfoRepository) :
    BaseUseCase<Resource<MyDataResponse>, Any>() {

    override suspend fun run(params: Any?): Resource<MyDataResponse> {
        return infoRepository.getInfo()
    }
}