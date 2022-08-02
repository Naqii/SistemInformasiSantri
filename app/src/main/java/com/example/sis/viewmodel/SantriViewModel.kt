package com.example.sis.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sis.data.api.ApiResponse
import com.example.sis.data.api.repository.MainRepository
import com.example.sis.data.model.SantriResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SantriViewModel @Inject constructor(
    private val repository: MainRepository
    ): ViewModel() {

    fun getSantri(): LiveData<ApiResponse<SantriResponse>> = repository.getSantri()

    fun setSrcSantri(id: String): LiveData<ApiResponse<SantriResponse>> = repository.getSrcSantri(id)
}