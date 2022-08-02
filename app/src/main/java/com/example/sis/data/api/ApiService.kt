package com.example.sis.data.api

import com.example.sis.data.model.SantriResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("santri")
    fun getSantri(): Call<SantriResponse>

    @GET("santri/{id}")
    fun getSrcSantri (
        @Path("id")
        id: String
    ): Call<SantriResponse>

    @POST("santri/{id}")
    fun getEdtSantri (
        @Path("id")
        id: String
    ): Call<SantriResponse>
}