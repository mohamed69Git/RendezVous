package com.example.rendez.services
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitFactory {
    const val BASE_URL = "http://192.168.43.228:8000/"

    fun makeRetrofitService(): RetrofitService{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create()).build().create(RetrofitService::class.java)
    }
}