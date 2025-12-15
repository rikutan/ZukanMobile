package com.example.zukanmobile.ui.screen.s2_list

data class ListUiState(
    val items: List<SpecieListItem> = emptyList(),
    val isRefreshing: Boolean = false
)