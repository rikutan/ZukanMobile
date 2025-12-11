package com.example.zukanmobile.ui.screen.s3_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zukanmobile.firebase.data.Specie
import com.example.zukanmobile.firebase.repository.SpecieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repo: SpecieRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    // 疑問：savedStateHandleってなんだ？
    private val specieId: String = savedStateHandle["specieId"] ?: ""

    private val _specie = MutableStateFlow<Specie?>(null)
    val specie = _specie.asStateFlow()

    // 疑問：initってなんだ？
    init {
        loadDetail()
    }

    private fun loadDetail() {
        viewModelScope.launch {
            _specie.value = repo.fetchSpecieId(specieId)
        }
    }
}