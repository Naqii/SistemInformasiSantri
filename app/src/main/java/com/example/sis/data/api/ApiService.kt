package com.example.sis.data.api

import com.example.sis.data.model.SantriItem
import com.example.sis.data.model.SantriResponse
import com.example.sis.data.model.UploadResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
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
    @Multipart
    @POST("santri")
    fun createSantri (
        @Body santri: SantriItem,
//        @Part("nis") nis: RequestBody,
//        @Part("name") name: RequestBody,
//        @Part("telp") telp: RequestBody,
//        @Part("address") address: RequestBody,
//        @Part("city") city: RequestBody,
//        @Part("province") province: RequestBody,
//        @Part("birth") birth: RequestBody,
//        @Part("email") email: RequestBody,
//        @Part foto: MultipartBody.Part,
//        @Part("nilai_sikap") nilai_sikap: RequestBody,
//        @Part("nilai_materi") nilai_materi: RequestBody,
//        @Part("nilai_bacaan") nilai_bacaan: RequestBody,
//        @Part("nilai_hafalan") nilai_hafalan: RequestBody,
//        @Part("presensi_hadir") presensi_hadir: RequestBody,
//        @Part("presensi_izin") presensi_izin: RequestBody,
//        @Part("presensi_alfa") presensi_keterangan: RequestBody,
//        @Part("kuliah_univ") kuliah_univ: RequestBody,
//        @Part("kuliah_univ") kuliah_progdi: RequestBody,
//        @Part("kuliah_univ") kuliah_jurusan: RequestBody,
//        @Part("kuliah_univ") kuliah_gelar: RequestBody,
//        @Path("id") id: String
    ): Call<UploadResponse>

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