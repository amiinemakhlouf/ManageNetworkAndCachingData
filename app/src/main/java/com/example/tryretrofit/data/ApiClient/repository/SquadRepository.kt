package com.example.tryretrofit.data.ApiClient.repository

import com.example.tryretrofit.data.ApiClient.Result as Result
import com.example.tryretrofit.data.ApiClient.SquadClient
import com.example.tryretrofit.data.ApiClient.model.Squad
import javax.inject.Inject

class SquadRepository @Inject constructor(
    val squadClient: SquadClient,
) {

    suspend fun getSquad() :Result{
        try {
            val result = squadClient.getSquad()
            return Result.Succes(result.body()?.postId)
        } catch(e:Exception) {
            return Result.Error(error = squadClient.getSquad().errorBody().toString())

        }

    }


}