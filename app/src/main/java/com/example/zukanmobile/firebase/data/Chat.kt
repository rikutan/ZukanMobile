package com.example.zukanmobile.firebase.data

data class Chat(
    val id: String = "",
    val partnerId: String = "",
    val theme: String = "",
    val msgs: List<String> = emptyList(),
)