package com.example.epoxyapp.network

import com.example.epoxyapp.data.remote.RemoteHomeDataSource
import com.example.epoxyapp.network.service.HomeService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson,
        endPoint: EpoxyEndPoint
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(endPoint.epoxyEndPoint)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): HomeService {
        return retrofit.create(HomeService::class.java)
    }

    @Provides
    fun provideEndPoint(): EpoxyEndPoint {
        return EpoxyEndPoint("https://611aa981822cb00017cbc4c5.mockapi.io/")
    }

    @Provides
    fun provideRemoteDataSource(apiService: HomeService): RemoteHomeDataSource {
        return RemoteHomeDataSource(apiService)
    }
}

data class EpoxyEndPoint(val epoxyEndPoint: String)