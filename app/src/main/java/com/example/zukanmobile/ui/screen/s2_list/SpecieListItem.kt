package com.example.zukanmobile.ui.screen.s2_list

// 一覧画面で表示するデータをまとめた data class
data class SpecieListItem(
    val id: String = "",
    val speciesName: String = "",
    val status: String = "",
    val imageUrl: String?
)