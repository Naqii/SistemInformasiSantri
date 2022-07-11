package com.example.sis.helper

import com.example.sis.model.ModelSantri
import org.json.JSONArray

class Helper {

    companion object {
        fun listSantriResponse(items: JSONArray): ArrayList<ModelSantri> {
            val listItem = ArrayList<ModelSantri>()
            for (i in 0 until items.length()) {
                val item = items.getJSONObject(i)
                val dataSantri = ModelSantri()
                dataSantri.id = item.getString("id")
                dataSantri.nis = item.getString("nis")
                dataSantri.name = item.getString("name")
                dataSantri.telp = item.getString("telp")
                listItem.add(dataSantri)
            }
            return listItem
        }
    }
}