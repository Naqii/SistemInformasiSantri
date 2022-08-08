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

    @POST("santri/{id}")
    fun createSantri (
        @Body santri: SantriItem,
        @Path("id") id: String,
        @Path("nis") nis: String,
        @Path("name") name: String,
        @Path("telp") telp: String,
        @Path("address") address: String,
        @Path("city") city: String,
        @Path("province") province: String,
        @Path("birth") birth: String,
        @Path("email") email: String,
        @Path("nilai_sikap") nilai_sikap: String,
        @Path("nilai_materi") nilai_materi: String,
        @Path("nilai_bacaan") nilai_bacaan: String,
        @Path("nilai_hafalan") nilai_hafalan: String,
        @Path("presensi_hadir") presensi_hadir: String,
        @Path("presensi_izin") presensi_izin: String,
        @Path("presensi_alfa") presensi_alfa: String,
        @Path("kampus_univ") kampus_univ: String,
        @Path("kampus_progdi") kampus_progdi: String,
        @Path("kampus_jurusan") kampus_jurusan: String,
        @Path("kampus_gelar") kampus_gelar: String,
        @Path("foto") foto: String
        ): Call<SantriResponse>

    @PUT("santri/{id}")
    fun edtSantri (
        @Path("id") id: String,
        @Path("nis") nis: String,
        @Path("name") name: String,
        @Path("telp") telp: String,
        @Path("address") address: String,
        @Path("city") city: String,
        @Path("province") province: String,
        @Path("birth") birth: String,
        @Path("email") email: String,
        @Path("nilai_sikap") nilai_sikap: String,
        @Path("nilai_materi") nilai_materi: String,
        @Path("nilai_bacaan") nilai_bacaan: String,
        @Path("nilai_hafalan") nilai_hafalan: String,
        @Path("presensi_hadir") presensi_hadir: String,
        @Path("presensi_izin") presensi_izin: String,
        @Path("presensi_alfa") presensi_alfa: String,
        @Path("kampus_univ") kampus_univ: String,
        @Path("kampus_progdi") kampus_progdi: String,
        @Path("kampus_jurusan") kampus_jurusan: String,
        @Path("kampus_gelar") kampus_gelar: String,
        @Path("foto") foto: String
    ): Call<SantriResponse>

    @PUT("santri/{id}")
    fun deleteSantri (
        @Path("id") id: String,
        @Path("nis") nis: String,
        @Path("name") name: String,
        @Path("telp") telp: String,
        @Path("address") address: String,
        @Path("city") city: String,
        @Path("province") province: String,
        @Path("birth") birth: String,
        @Path("email") email: String,
        @Path("nilai_sikap") nilai_sikap: String,
        @Path("nilai_materi") nilai_materi: String,
        @Path("nilai_bacaan") nilai_bacaan: String,
        @Path("nilai_hafalan") nilai_hafalan: String,
        @Path("presensi_hadir") presensi_hadir: String,
        @Path("presensi_izin") presensi_izin: String,
        @Path("presensi_alfa") presensi_alfa: String,
        @Path("kampus_univ") kampus_univ: String,
        @Path("kampus_progdi") kampus_progdi: String,
        @Path("kampus_jurusan") kampus_jurusan: String,
        @Path("kampus_gelar") kampus_gelar: String,
        @Path("foto") foto: String
    ): Call<SantriResponse>
}