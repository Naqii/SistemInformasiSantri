package com.example.sis.data.model

import android.os.Message
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class SantriResponse(

    val santri: ArrayList<SantriItem>? = null,

    val status: Boolean? = null,
    val error: Boolean? = null,
    val messages: String? = null
)

@Parcelize
data class SantriItem(

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("nis")
    val nis: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("telp")
    val telp: String? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("city")
    val city: String? = null,

    @field:SerializedName("province")
    val province: String? = null,

    @field:SerializedName("birth")
    val birth: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("foto")
    val foto: String? = null,

    @field:SerializedName("nilai_sikap")
    val nilaiSikap: String? = null,

    @field:SerializedName("nilai_materi")
    val nilaiMateri: String? = null,

    @field:SerializedName("nilai_bacaan")
    val nilaiBacaan: String? = null,

    @field:SerializedName("nilai_hafalan")
    val nilaiHafalan: String? = null,

    @field:SerializedName("presensi_hadir")
    val presensiHadir: String? = null,

    @field:SerializedName("presensi_izin")
    val presensiIzin: String? = null,

    @field:SerializedName("presensi_alfa")
    val presensiAlfa: String? = null,

    @field:SerializedName("presensi_keterangan")
    val presensiKeterangan: String? = null,

    @field:SerializedName("kampus_univ")
    val kampusUniv: String? = null,

    @field:SerializedName("kampus_progdi")
    val kampusProgdi: String? = null,

    @field:SerializedName("kampus_jurusan")
    val kampusJurusan: String? = null,

    @field:SerializedName("kampus_gelar")
    val kampusGelar: String? = null,
) : Parcelable

data class Response(

    @SerializedName("status")
    val status: Int? = null,

    @SerializedName("error")
    val error: String? = null,

    @SerializedName("message")
    val message: SantriItem = SantriItem()

)
