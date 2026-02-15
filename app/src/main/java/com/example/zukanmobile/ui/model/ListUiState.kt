package com.example.zukanmobile.ui.model

data class ListUiState(
    val items: List<SpecieListItem> = emptyList(),
    val isRefreshing: Boolean = false
)