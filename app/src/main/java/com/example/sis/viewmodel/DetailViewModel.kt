package com.example.sis.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sis.data.api.ApiResponse
import com.example.sis.data.api.repository.MainRepository
import com.example.sis.data.model.SantriItem
import com.example.sis.data.model.SantriResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    val listUser = MutableLiveData<ArrayList<SantriItem>>()

    fun setDetailUser(id: String): LiveData<ApiResponse<SantriResponse>> =
        repository.getSrcSantri(id)

    fun getDetailUser(): LiveData<ArrayList<SantriItem>> {
        return listUser
    }
}