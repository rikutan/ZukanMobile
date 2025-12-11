package com.example.zukanmobile.firebase.data

data class Specie(
    val id: String = "",
    val speciesName: String = "",
    val status: String = "",
    val feature: String = "",
    val personality: List<String> = emptyList()
)
