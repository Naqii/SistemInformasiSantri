package com.example.sis.data.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("santri")
    fun getListSantri(): Call<SantriResponse>

    @GET("santri/{id}")
    fun getDetailSantri (
        @Path("id")
        id: String
    ): Call<SantriResponse>
}