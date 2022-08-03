package com.example.sis.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class SantriResponse(

    val santri: ArrayList<SantriItem>? = null
)

@Parcelize
data class SantriItem(

    @field:SerializedName("telp")
    val telp: String,

    @field:SerializedName("address")
    val address: String,

    @field:SerializedName("city")
    val city: String,

    @field:SerializedName("nilai_materi")
    val nilaiMateri: String,

    @field:SerializedName("nilai_bacaan")
    val nilaiBacaan: String,

    @field:SerializedName("birth")
    val birth: String,

    @field:SerializedName("presensi_hadir")
    val presensiHadir: String,

    @field:SerializedName("presensi_izin")
    val presensiIzin: String,

    @field:SerializedName("kampus_progdi")
    val kampusProgdi: String,

    @field:SerializedName("kampus_jurusan")
    val kampusJurusan: String,

    @field:SerializedName("nilai_hafalan")
    val nilaiHafalan: String,

    @field:SerializedName("province")
    val province: String,

    @field:SerializedName("foto")
    val foto: String,

    @field:SerializedName("presensi_keterangan")
    val presensiKeterangan: String,

    @field:SerializedName("kampus_univ")
    val kampusUniv: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("nis")
    val nis: String,

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("nilai_sikap")
    val nilaiSikap: String,

    @field:SerializedName("kampus_gelar")
    val kampusGelar: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("presensi_alfa")
    val presensiAlfa: String
) : Parcelable
