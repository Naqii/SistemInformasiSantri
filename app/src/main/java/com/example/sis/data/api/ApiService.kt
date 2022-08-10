package com.example.sis.data.api

import com.example.sis.data.model.Response
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
        @Body santri: SantriItem,
//        @Field("nis") nis: String,
//        @Field("name") name: String,
//        @Field("telp") telp: String,
//        @Field("address") address: String,
//        @Field("city") city: String,
//        @Field("province") province: String,
//        @Field("birth") birth: String,
//        @Field("email") email: String,
//        @Field("foto") foto: String,
//        @Field("nilai_sikap") nilai_sikap: String,
//        @Field("nilai_materi") nilai_materi: String,
//        @Field("nilai_bacaan") nilai_bacaan: String,
//        @Field("nilai_hafalan") nilai_hafalan: String,
//        @Field("presensi_hadir") presensi_hadir: String,
//        @Field("presensi_izin") presensi_izin: String,
//        @Field("presensi_alfa") presensi_alfa: String,
//        @Field("kampus_univ") kampus_univ: String,
//        @Field("kampus_progdi") kampus_progdi: String,
//        @Field("kampus_jurusan") kampus_jurusan: String,
//        @Field("kampus_gelar") kampus_gelar: String
    ): Call<Response>

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