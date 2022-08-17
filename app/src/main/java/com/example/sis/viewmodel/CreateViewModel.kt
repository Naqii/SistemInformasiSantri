package com.example.sis.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sis.data.api.ApiResponse
import com.example.sis.data.api.repository.MainRepository
import com.example.sis.data.model.SantriItem
import com.example.sis.data.model.SantriResponse
import com.example.sis.data.model.UploadResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    
    fun createSantri(santri: SantriItem): MutableLiveData<ApiResponse<UploadResponse>> =
        repository.createSantri(santri)
}