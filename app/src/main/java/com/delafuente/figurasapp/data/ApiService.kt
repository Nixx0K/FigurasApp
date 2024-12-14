package com.delafuente.figurasapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("figuras")
    suspend fun getFiguras(): List<Figura>

    @GET("figuras/{id}")
    suspend fun getFiguraDetail(@Path("id") id: Int): Figura
}
val retrofit = Retrofit.Builder()
    .baseUrl("https://figuras-n900keow2-talento-projects.vercel.app/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(ApiService::class.java)