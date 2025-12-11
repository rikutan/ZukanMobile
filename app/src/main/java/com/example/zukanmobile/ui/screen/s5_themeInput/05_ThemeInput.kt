package com.example.zukanmobile.ui.screen.s5_themeInput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zukanmobile.ui.components.CustomButton
import com.example.zukanmobile.ui.components.TopBar
import com.example.zukanmobile.ui.components.textField.ThemeTextField
import com.example.zukanmobile.ui.theme.DeepTealBlue
import com.example.zukanmobile.ui.theme.White
import com.example.zukanmobile.ui.theme.mainFont

@Composable
fun ThemeInputScreen(modifier: Modifier = Modifier, onBack: () -> Unit, onSend: () -> Unit) {
    Scaffold(
        containerColor = DeepTealBlue,
        topBar = { TopBar(title = "", onBack = onBack) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "会話のテーマを入力してください",
                color = White,
                fontFamily = mainFont,
                fontSize = 28.sp
            )
            ThemeTextField(
                value = "",
                onValueChange = {},
                height = 240.dp,
                modifier = Modifier.padding(vertical = 36.dp)
            )
            CustomButton(buttonText = "送信") { onSend() }
        }
    }
}

@Preview
@Composable
private fun ThemeInputPreview() {
    ThemeInputScreen(onBack = {}, onSend = {})
}