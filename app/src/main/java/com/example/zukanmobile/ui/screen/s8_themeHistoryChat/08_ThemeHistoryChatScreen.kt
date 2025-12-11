package com.example.zukanmobile.ui.screen.s8_themeHistoryChat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zukanmobile.R
import com.example.zukanmobile.ui.components.ChatSpeechBubbleLeft
import com.example.zukanmobile.ui.components.ChatSpeechBubbleRight
import com.example.zukanmobile.ui.components.TopBar
import com.example.zukanmobile.ui.theme.DeepTealBlue
import com.example.zukanmobile.ui.theme.MidnightNavy

@Composable
fun ThemeHistoryChatScreen(modifier: Modifier = Modifier, onBack: () -> Unit) {
    val size = 50.dp
    Scaffold(
        containerColor = DeepTealBlue,
        topBar = {
            TopBar(title = "", onBack = onBack)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MidnightNavy)
                .padding(paddingValues)
                .padding(horizontal = 8.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {

            ChatSpeechBubbleLeft(
                image = R.drawable.t_00001,
                name = "ありが",
                chatText = "hello",
                size = size
            )
            ChatSpeechBubbleRight(
                image = R.drawable.t_00001,
                name = "あかお",
                chatText = "hello",
                modifier = Modifier.align(Alignment.End),
                size = size
            )
        }
    }

}

@Preview
@Composable
private fun ThemeHistoryChatScreenPreview() {
    ThemeHistoryChatScreen(onBack = {})
}