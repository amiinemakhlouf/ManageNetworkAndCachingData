package com.example.tryretrofit.data.ApiClient.DI

import com.example.tryretrofit.data.ApiClient.Constants
import com.example.tryretrofit.data.ApiClient.SipmleClient
import com.example.tryretrofit.data.ApiClient.repository.SquadRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
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
    fun provideSquadService(retrofit: Retrofit):SipmleClient{
        return  retrofit.create(SipmleClient::class.java)
    }
    @Provides
    @Singleton
    fun provideRepo(sipmleClient: SipmleClient):SquadRepository{
        return SquadRepository(sipmleClient)
    }


}