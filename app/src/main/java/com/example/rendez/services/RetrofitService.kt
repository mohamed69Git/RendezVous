package com.example.rendez.services

import android.text.Editable
import com.example.rendez.LoginBody
import com.example.rendez.LoginResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface RetrofitService {

    @GET("api/test")
    suspend fun getPosts(): Response<String>

    @POST("api/login")
    suspend fun login(@Body() body: LoginBody): Response<LoginResponse>
}