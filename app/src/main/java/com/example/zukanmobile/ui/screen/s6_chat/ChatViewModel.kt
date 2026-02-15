package com.example.zukanmobile.ui.screen.s6_chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zukanmobile.firebase.data.toChatSpecie
import com.example.zukanmobile.firebase.repository.SpecieRepository
import com.example.zukanmobile.gemini.repository.GeminiPromptBuilder
import com.example.zukanmobile.gemini.repository.GeminiRepository
import com.example.zukanmobile.gemini.repository.GeminiResponseParser
import com.example.zukanmobile.ui.model.ChatMessageUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val specieRepository: SpecieRepository,
    private val geminiRepository: GeminiRepository,
) : ViewModel() {

    private val _messages = MutableStateFlow<List<ChatMessageUiModel>>(emptyList())
    val messages: StateFlow<List<ChatMessageUiModel>> = _messages

    fun startChat(
        specieId: String,
        partnerId: String,
        theme: String,
    ) {
        viewModelScope.launch {
            val self = specieRepository.fetchSpecieId(specieId)
            val partner = specieRepository.fetchSpecieId(partnerId)

            val prompt = GeminiPromptBuilder.buildChatPrompt(
                from = self!!.toChatSpecie(),
                partner = partner!!.toChatSpecie(),
                theme = theme
            )

            val chatText = geminiRepository.generate(prompt)

            val parsed = GeminiResponseParser.parse(
                response = chatText,
                selfName = self.speciesName
            )

            _messages.value = parsed
        }
    }
}