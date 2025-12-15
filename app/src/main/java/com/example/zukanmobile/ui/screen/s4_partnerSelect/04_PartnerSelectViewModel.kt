package com.example.zukanmobile.ui.screen.s4_partnerSelect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zukanmobile.firebase.repository.SpecieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PartnerSelectViewModel @Inject constructor(
    private val repo: SpecieRepository
) : ViewModel() {

    private val _specieList = MutableStateFlow<List<SpeciePartnerSelectItem>>(emptyList())
    val specieList = _specieList.asStateFlow()

    private val _selectedSpecie = MutableStateFlow<SpeciePartnerSelectItem?>(null)
    val selectedSpecie = _selectedSpecie.asStateFlow()

    init {
        viewModelScope.launch {
            _specieList.value = repo.fetchPartnerSelectItems()
        }
    }

    fun onSpecieSelected(item: SpeciePartnerSelectItem) {
        _selectedSpecie.value = item
    }
}