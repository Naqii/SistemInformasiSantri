package com.example.sis.data.api

import com.example.sis.data.model.SantriItem
import com.example.sis.data.model.SantriResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("santri")
    fun getSantri(): Call<SantriResponse>

    @GET("santri/{id}")
    fun getSrcSantri (
        @Path("id")
        id: String
    ): Call<SantriResponse>

//    @FormUrlEncoded
    @POST("santri")
    fun createSantri (
        @Body santri: SantriItem
//        @Path("id") id: String
    ): Call<SantriItem>

    @PUT("santri/{id}")
    fun updateSantri (
        @Path("id") id: String,
        @Body santri: SantriItem
    ): Call<SantriResponse>

    @DELETE("santri/{id}")
    fun deleteSantri (
        @Path("id") id: String
    ): Call<SantriResponse>
}