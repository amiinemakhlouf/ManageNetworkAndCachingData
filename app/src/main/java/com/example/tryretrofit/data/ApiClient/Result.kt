package com.example.tryretrofit.data.ApiClient

import com.example.tryretrofit.data.ApiClient.model.Squad

sealed  class Result(  val squad: Int?,val error: String?=null)  {

    class  Succes( squad: Int?=null,error: String?=null) :Result(squad,error)
    class Error( squad: Int?=null,error: String?=null) :Result(squad,error)
}