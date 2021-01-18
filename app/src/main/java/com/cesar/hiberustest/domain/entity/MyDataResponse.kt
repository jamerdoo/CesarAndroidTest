package com.cesar.hiberustest.domain.entity

import com.google.gson.annotations.SerializedName

data class MyDataResponse (
    @SerializedName("data") val data : List<MyData>?,
    @SerializedName("total") val total : Int,
    @SerializedName("page") val page : Int,
    @SerializedName("limit") val limit : Int,
    @SerializedName("offset") val offset : Int
)
data class MyData(
    @SerializedName("id") val id : String,
    @SerializedName("lastName") val lastName : String,
    @SerializedName("firstName") val firstName : String,
    @SerializedName("email") val email : String,
    @SerializedName("title") val title : String,
    @SerializedName("picture") val picture : String
)