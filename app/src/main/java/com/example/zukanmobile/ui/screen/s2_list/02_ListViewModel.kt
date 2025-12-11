package com.example.zukanmobile.ui.screen.s2_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zukanmobile.firebase.repository.SpecieRepository
import com.example.zukanmobile.ui.screen.s2_list.SpecieListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repo: SpecieRepository
) : ViewModel() {

    private val _species = MutableStateFlow<List<SpecieListItem>>(emptyList())
    val species = _species.asStateFlow()

    fun loadSpecies() {
        viewModelScope.launch {
            _species.value = repo.fetchSpecieListItems()
        }
    }
}