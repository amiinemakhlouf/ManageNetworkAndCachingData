package com.example.tryretrofit.data.ApiClient

import com.example.tryretrofit.data.ApiClient.model.Squad

sealed  class Result(  val squad: String?,val error: String?=null)  {

    class  Succes( squad: String?=null,error: String?=null) :Result(squad,error)
    class Error( squad: String?=null,error: String?=null) :Result(squad,error)
}