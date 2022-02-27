package com.example.tryretrofit.data.ApiClient.model

data class Squad(
    val active: Boolean,
    val formed: Int,
    val homeTown: String,
    val secretBase: String,
    val squadName: String
)