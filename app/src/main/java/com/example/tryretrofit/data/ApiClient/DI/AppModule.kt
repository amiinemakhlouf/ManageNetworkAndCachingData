package com.example.tryretrofit.data.ApiClient.DI

import com.example.tryretrofit.data.ApiClient.Constants
import com.example.tryretrofit.data.ApiClient.SquadClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {

        return Retrofit.Builder().baseUrl(Constants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Provides
    @Singleton
    fun provideSquadService(retrofit: Retrofit):SquadClient{
        return  retrofit.create(SquadClient::class.java)
    }


}