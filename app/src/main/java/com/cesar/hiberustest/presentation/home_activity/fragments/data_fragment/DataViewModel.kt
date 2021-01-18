package com.cesar.hiberustest.presentation.home_activity.fragments.data_fragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cesar.hiberustest.domain.Resource
import com.cesar.hiberustest.domain.entity.MyData
import com.cesar.hiberustest.domain.repository.InfoDataSource
import com.cesar.hiberustest.domain.repository.InfoRepository
import com.cesar.hiberustest.domain.usercase.GetInfo
import com.cesar.hiberustest.network.InfoDataSourceImpl
import com.cesar.hiberustest.network.RetrofitProvider

class DataViewModel : ViewModel() {


    private var infoDataSource: InfoDataSource = InfoDataSourceImpl(RetrofitProvider())
    private var getInfo = GetInfo(InfoRepository(infoDataSource))

    var myDataLiveData = MutableLiveData<Resource<List<MyData>>>()
    var firstTime = true

    fun getData(){
        if(!firstTime){
            return
        }

        firstTime = false
        myDataLiveData.value = Resource.Loading()

        getInfo.invoke(onResult = { it ->

            val myfinalmodel = it.data?.data?.map { it ->
                MyData(it.id,it.lastName,it.firstName,it.email,it.title,it.picture)
            }


            myDataLiveData.value = Resource.Success( myfinalmodel?.sortedBy { it.firstName }?: emptyList())

        }, onError = {
            Log.d("","")
        })
    }
}