package com.example.tryretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.tryretrofit.data.ApiClient.MainActivityVM
import com.example.tryretrofit.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel :MainActivityVM by viewModels()
    private  lateinit var  binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(!viewModel.HasInternetConnection(this)){

            Log.d("AppDebug","not internet connection")

        }



        viewModel._squadClient.observe(this){


            if(it=="error"){

                Toast.makeText(this,"not found",Toast.LENGTH_SHORT).show()
            }
            else{
                binding.ETID.setText(it)
            }


        }

        lifecycleScope.launch{

            withContext(IO){



                //viewModel.getSquad()
            }

        }

    }

}