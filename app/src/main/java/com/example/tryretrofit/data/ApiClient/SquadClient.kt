package com.example.tryretrofit.data.ApiClient

import com.example.tryretrofit.data.ApiClient.model.Squad
import retrofit2.Response
import retrofit2.http.GET

interface SquadClient {

    @GET("test")
     suspend fun getSquad() :  Squad

}