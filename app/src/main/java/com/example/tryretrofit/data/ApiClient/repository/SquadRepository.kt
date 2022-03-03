package com.example.tryretrofit.data.ApiClient.repository

import com.example.tryretrofit.data.ApiClient.SipmleClient
import retrofit2.Retrofit
import java.util.concurrent.TimeoutException
import com.example.tryretrofit.data.ApiClient.Result as Result
import javax.inject.Inject

class SquadRepository @Inject constructor(
    val sipmleClient: SipmleClient,
) {

    suspend fun getSquad() :Result{
        try {
            val result = sipmleClient.getSipmle()
            return Result.Succes(result.body()?.name)
        } catch(timeoutException:TimeoutException) {
            return Result.Error("ggggggggggg")

        }


    }


}