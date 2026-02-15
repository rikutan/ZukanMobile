package com.example.zukanmobile.gemini.repository

import com.example.zukanmobile.ui.model.ChatMessageUiModel

object GeminiResponseParser {

    fun parse(
        response: String,
        selfName: String
    ): List<ChatMessageUiModel> {
        return response
            .lines()
            .filter { it.contains(":") }
            .map { line ->
                val (speaker, message) = line.split(":", limit = 2)
                ChatMessageUiModel(
                    speakerName = speaker.trim(),
                    message = message.trim(),
                    isFromSelf = speaker.trim() == selfName
                )
            }
    }
}