package com.example.tryretrofit.data.ApiClient

sealed interface DataState{

    object Succes : DataState
    object Error : DataState
}