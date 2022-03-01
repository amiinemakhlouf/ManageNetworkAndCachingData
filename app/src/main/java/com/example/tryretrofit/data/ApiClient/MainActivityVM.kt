package com.example.tryretrofit.data.ApiClient

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityVM @Inject constructor( private  val squadClient: SquadClient) :ViewModel(){
     private var squadClientState=MutableLiveData<String>("")
      var _squadClient=squadClientState ;private set
    fun getSquad()=
        viewModelScope.launch {
            val squad=squadClient.getSquad().squadName
            squadClientState.postValue(squad)
        }

}sdrromkkkkkkk
>>>>>>> mybranch

