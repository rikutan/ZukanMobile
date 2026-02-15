package com.example.zukanmobile.firebase.data

import com.example.zukanmobile.ui.model.ChatCharacterUiModel

fun Specie.toChatSpecie(): ChatCharacterUiModel {
    return ChatCharacterUiModel(
        id = id,
        speciesName = speciesName,
        feature = feature,
        personality = personality
    )
}