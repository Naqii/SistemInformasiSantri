package com.example.sis.data.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SantriResponse(
    val santriResponse: List<SantriResponseItem>? = null
) : Parcelable

@Parcelize
data class SantriResponseItem(

    @field:SerializedName("telp")
    val telp: String? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("province")
    val province: String? = null,

    @field:SerializedName("city")
    val city: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("nis")
    val nis: String? = null,

    @field:SerializedName("birth")
    val birth: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("email")
    val email: String? = null
) : Parcelable

//@Parcelize
//data class Infosantri(
//    @field:SerializedName("santri")
//    val santri: List<SantriResponseItem>? = null
//) : Parcelable

//@Parcelize
//data class DataSantri(
//
//	@field:SerializedName("data_santri")
//	val santri: SantriResponseItem? = null
//) : Parcelable