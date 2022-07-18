package com.example.sis.data.api.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sis.data.api.*
import com.example.sis.data.model.SantriResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(private val service: ApiService) {

    fun getSantri(): LiveData<ApiResponse<SantriResponse>>{
        val result = MutableLiveData<ApiResponse<SantriResponse>>()
        val api = service.getListSantri()
        api.enqueue(object : Callback<SantriResponse>{
            override fun onResponse(
                call: Call<SantriResponse>,
                response: Response<SantriResponse>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        result.value = ApiResponse.success(body)
                    } else {
                        result.value = ApiResponse.error("No response", SantriResponse())
                    }
                }
            }

            override fun onFailure(call: Call<SantriResponse>, t: Throwable) {
                result.value = ApiResponse.error(
                    "Error reported [UNKNOWN]",
                    SantriResponse()
                )
            }
        })
        return result
    }

//    fun getSantri() =
//    fun getSantri() = service.getListSantri()
}