package com.example.rendez.services

import android.text.Editable
import com.example.rendez.LoginBody
import com.example.rendez.LoginResponse
import com.example.rendez.RegisterBody
import com.google.gson.JsonObject
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import retrofit2.http.GET

interface RetrofitService {

    @GET("/api/hello")
    suspend fun getHello(): Response<String>

    @POST("api/login")
    suspend fun login(@Body() body: LoginBody): Response<LoginResponse>

    @POST("api/register")
    suspend fun register(@Body() body: RegisterBody): Response<JsonObject>

//    @Headers("Authorization: ", "Bearer")
//    @GET("api/Profiles/GetProfile?id={id}")
//    fun getUser(@Path("id") id: String?): Call<UserProfile?>?
}