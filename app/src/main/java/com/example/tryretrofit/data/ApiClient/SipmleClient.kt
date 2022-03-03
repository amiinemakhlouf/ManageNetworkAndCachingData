package com.example.tryretrofit.data.ApiClient

import com.example.tryretrofit.data.ApiClient.model.Simple
import com.example.tryretrofit.data.ApiClient.model.Squad
import retrofit2.Response
import retrofit2.http.GET

interface SipmleClient {

    @GET("?name=meelad1")
     suspend fun getSipmle() :  Response<Simple>

}