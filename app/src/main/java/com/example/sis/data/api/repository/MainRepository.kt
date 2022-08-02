package com.example.sis.data.api.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.sis.data.api.ApiResponse
import com.example.sis.data.api.ApiService
import com.example.sis.data.model.SantriItem
import com.example.sis.data.model.SantriResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(private val service: ApiService) {

    fun getSantri(): MutableLiveData<ApiResponse<SantriResponse>> {
        val item = MutableLiveData<ApiResponse<SantriResponse>>()
        val api = service.getSantri()
        api.enqueue(object : Callback<SantriResponse>{
            override fun onResponse(
                call: Call<SantriResponse>,
                response: Response<SantriResponse>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        item.value = ApiResponse.success(body)
                    } else {
                        item.value = ApiResponse.error("No response", SantriResponse())
                    }
                }
            }

            override fun onFailure(call: Call<SantriResponse>, t: Throwable) {
                item.value = ApiResponse.error(
                    "Error reported [UNKNOWN]",
                    SantriResponse()
                )
            }
        })
        return item
    }
    //awalnya set
    fun getSrcSantri(id: String): MutableLiveData<ApiResponse<SantriResponse>> {
        val item = MutableLiveData<ApiResponse<SantriResponse>>()
        val api = service.getSrcSantri(id)
        api.enqueue(object : Callback<SantriResponse>{
            override fun onResponse(
                call: Call<SantriResponse>,
                response: Response<SantriResponse>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        item.postValue(ApiResponse.success(body))
                    } else {
                        item.postValue(ApiResponse.error("No Response", SantriResponse()))
                    }
                }
            }

            override fun onFailure(call: Call<SantriResponse>, t: Throwable) {
                t.message?.let { Log.d("Failure", it) }
            }

        })
        return item
    }
}