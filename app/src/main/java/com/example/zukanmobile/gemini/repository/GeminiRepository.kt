package com.example.zukanmobile.gemini.repository

import com.google.firebase.ai.GenerativeModel
import javax.inject.Inject


class GeminiRepository @Inject constructor(
    private val model: GenerativeModel
) {
    suspend fun generate(prompt: String): String {
        val response = model.generateContent(prompt)
        return response.text.orEmpty()
    }
}