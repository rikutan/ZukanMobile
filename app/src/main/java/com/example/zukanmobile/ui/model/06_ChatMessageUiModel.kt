package com.example.zukanmobile.ui.model

data class ChatMessageUiModel(
    val speakerName: String,
    val message: String,
    val isFromSelf: Boolean,
)
