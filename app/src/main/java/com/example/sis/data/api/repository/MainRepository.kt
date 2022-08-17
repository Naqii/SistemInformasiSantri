package com.example.sis.data.api.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.sis.data.api.ApiClient
import com.example.sis.data.api.ApiResponse
import com.example.sis.data.api.ApiService
import com.example.sis.data.model.SantriItem
import com.example.sis.data.model.SantriResponse
import com.example.sis.data.model.UploadResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(private val service: ApiService) {

    //get All
    fun getSantri(): MutableLiveData<ApiResponse<SantriResponse>> {
        val item = MutableLiveData<ApiResponse<SantriResponse>>()
        val api = service.getSantri()
        api.enqueue(object : Callback<SantriResponse> {
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

    //get By Id
    fun getSrcSantri(id: String): MutableLiveData<ApiResponse<SantriResponse>> {
        val item = MutableLiveData<ApiResponse<SantriResponse>>()
        val api = service.getSrcSantri(id)
        api.enqueue(object : Callback<SantriResponse> {
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

    fun createSantri(santri: SantriItem): MutableLiveData<ApiResponse<UploadResponse>> {
        val item = MutableLiveData<ApiResponse<UploadResponse>>()
        val api = service.createSantri(santri)
        api.enqueue(object : Callback<UploadResponse>{
            override fun onResponse(
                call: Call<UploadResponse>,
                response: Response<UploadResponse>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        item.postValue(ApiResponse.success(body))
                    } else {
                        item.postValue(ApiResponse.error("No Response", UploadResponse()))
                    }
                }
            }

            override fun onFailure(call: Call<UploadResponse>, t: Throwable) {
                t.message?.let { Log.d("Failure", it) }
            }

        })
        return item
    }

    //update
    fun updateSantri(santri: SantriItem): MutableLiveData<ApiResponse<SantriResponse>> {
        val item = MutableLiveData<ApiResponse<SantriResponse>>()
        val api = santri.id?.let { service.updateSantri(it, santri) }
        api?.enqueue(object : Callback<SantriResponse> {
            override fun onResponse(
                call: Call<SantriResponse>,
                response: Response<SantriResponse>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<SantriResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return item
    }
}