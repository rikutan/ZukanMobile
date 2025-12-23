package com.example.zukanmobile

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {

    private val _baseSpecieId = MutableStateFlow<String?>(null)
    val baseSpecieId = _baseSpecieId.asStateFlow()

    private val _partnerSpecieId = MutableStateFlow<String?>(null)
    val partnerSpecieId = _partnerSpecieId.asStateFlow()

    private val _theme = MutableStateFlow<String?>(null)
    val theme = _theme.asStateFlow()


    fun setBaseSpecie(id: String) {
        _baseSpecieId.value = id
    }

    fun setPartnerSpecie(id: String) {
        _partnerSpecieId.value = id
    }

    fun setTheme(theme: String) {
        _theme.value = theme
    }

    fun clear() {
        _partnerSpecieId.value = null
        _theme.value = null
    }

}