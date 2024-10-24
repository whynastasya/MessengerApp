package com.example.messenagerapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MessengerService {
    private const val BASE_URL = "http://193.124.33.25:8080/swagger/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val messengerApi: MessengerApi = retrofit.create(MessengerApi::class.java)
}