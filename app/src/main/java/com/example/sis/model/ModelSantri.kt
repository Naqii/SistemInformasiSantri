package com.example.sis.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.sis.model.ModelSantri.Companion.TABLE_NAME
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = TABLE_NAME)
data class ModelSantri (

    @ColumnInfo(name = "id")
    var id: String = "",

    @ColumnInfo(name = "nis")
    var nis: String = "",

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "telp")
    var telp: String = "",

    @ColumnInfo(name = "address")
    var address: String = "",

    @ColumnInfo(name = "city")
    var city: String = "",

    @ColumnInfo(name = "province")
    var province: String = "",

    @ColumnInfo(name = "birth")
    var birth: String = "",

    @ColumnInfo(name = "email")
    var email: String = "",

): Parcelable {
    companion object {
        const val TABLE_NAME = "data_santri"
    }
}