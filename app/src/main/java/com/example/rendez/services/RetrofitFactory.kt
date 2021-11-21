package com.example.rendez.services
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitFactory {
    const val BASE_URL = "http://10.157.37.18:8000"

    fun makeRetrofitService(): RetrofitService{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(RetrofitService::class.java)
    }
}