package com.example.zukanmobile.ui.model

data class ChatCharacterUiModel(
    val id: String,
    val speciesName: String,
    val feature: String,
    val personality: List<String> = emptyList()
)