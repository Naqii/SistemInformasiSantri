package com.example.sis.data.model

import com.google.gson.annotations.SerializedName

data class SantriResponse(

	val santri: List<SantriItem>? = null
)

data class SantriItem(

	@field:SerializedName("telp")
	val telp: String,

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("province")
	val province: String,

	@field:SerializedName("city")
	val city: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("nis")
	val nis: String,

	@field:SerializedName("birth")
	val birth: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("email")
	val email: String
)
