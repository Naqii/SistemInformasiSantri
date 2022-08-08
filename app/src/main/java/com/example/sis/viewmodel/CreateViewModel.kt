package com.example.sis.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sis.data.api.repository.MainRepository
import com.example.sis.data.model.SantriItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    val listSantri = MutableLiveData<ArrayList<SantriItem>>()

    fun createSantri(santri: SantriItem, id: String) {
        repository.createSantri(santri, id)
    }
}