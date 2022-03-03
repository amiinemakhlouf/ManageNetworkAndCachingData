package com.example.tryretrofit.data.ApiClient

import android.content.Context
import android.net.*
import android.os.Build
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tryretrofit.data.ApiClient.repository.SquadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainActivityVM @Inject constructor( private  val squadRepository: SquadRepository) :ViewModel(){
     private var squadClientState=MutableLiveData<String>("no internet")
      var _squadClient=squadClientState ;private set


    fun getSquad()=
        viewModelScope.launch {
            when(squadRepository.getSquad()){

                is Result.Succes -> squadClientState.postValue(squadRepository.getSquad().squad)

                is Result.Error -> squadClientState.postValue(squadRepository.getSquad().error)


        }


        }

     fun HasInternetConnection(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val nw      = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                //for check internet over Bluetooth
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
                else -> false
            }
        } else {
            return connectivityManager.activeNetworkInfo?.isConnected ?: false
        }
    }



}
