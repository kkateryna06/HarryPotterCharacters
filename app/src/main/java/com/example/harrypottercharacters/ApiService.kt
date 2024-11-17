package com.example.harrypottercharacters

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .baseUrl("https://hp-api.onrender.com/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val characterService = retrofit.create(ApiService::class.java)

interface ApiService{
    @GET("characters")
    suspend fun getCharacters(): List<Character>
}