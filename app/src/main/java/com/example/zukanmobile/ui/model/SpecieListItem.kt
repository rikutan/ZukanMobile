package com.example.zukanmobile.ui.model

// 一覧画面で表示するデータをまとめた data class
data class SpecieListItem(
    val id: String = "",
    val speciesName: String = "",
    val status: String = "",
    val imageUrl: String?
)