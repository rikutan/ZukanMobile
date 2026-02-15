package com.example.zukanmobile.gemini.repository

import com.example.zukanmobile.ui.model.ChatCharacterUiModel

object GeminiPromptBuilder {

    fun buildChatPrompt(
        from: ChatCharacterUiModel,
        partner: ChatCharacterUiModel,
        theme: String,
    ): String {
        val fromPersonality = from.personality.joinToString("、")
        val partnerPersonality = partner.personality.joinToString("、")
        return """
            あなたは会話生成AIです。
            
            【${from.speciesName}の性格と特徴】
            性格: $fromPersonality
            特徴: ${from.feature}
            
            【${partner.speciesName}の性格と特徴】
            性格: $partnerPersonality
            特徴: ${partner.feature}
            
            【会話テーマ】
            $theme
            
            【指示】
            ${from.speciesName}と${partner.speciesName}がこのテーマについて8ターン会話してください。
            必ず以下の形式で返してください:
            
            ${from.speciesName}:（セリフ）
            ${partner.speciesName}:（セリフ）
            ・・・
            
            ・必ず合計16行
            ・キャラクター性を守る
            
        """.trimIndent()
    }
}