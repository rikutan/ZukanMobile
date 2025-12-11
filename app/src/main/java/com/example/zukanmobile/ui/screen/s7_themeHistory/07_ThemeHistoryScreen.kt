package com.example.zukanmobile.ui.screen.s7_themeHistory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zukanmobile.ui.components.CustomButton
import com.example.zukanmobile.ui.components.HistoryTheme
import com.example.zukanmobile.ui.components.TopBar
import com.example.zukanmobile.ui.theme.DeepTealBlue
import com.example.zukanmobile.ui.theme.White
import com.example.zukanmobile.ui.theme.mainFont

@Composable
fun ThemeHistoryScreen(modifier: Modifier = Modifier, onBack: () -> Unit, onNavigate: () -> Unit) {
    Scaffold(
        containerColor = DeepTealBlue,
        topBar = {
            TopBar(title = "履歴", onBack = onBack)
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(20) {
                HistoryTheme(height = 70.dp) { onNavigate() }
            }
        }

//        NoneHistoryTheme(modifier = Modifier.padding(paddingValues)) { }
    }
}

// 履歴がない時のコンポーネント
@Composable
fun NoneHistoryTheme(modifier: Modifier, onNavigate: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "他種族と交流してみよう！",
            color = White,
            fontFamily = mainFont,
            fontSize = 36.sp
        )
        Spacer(Modifier.height(60.dp))

        CustomButton(buttonText = "他種族と交流する") { onNavigate() }
    }
}

@Preview
@Composable
private fun ThemeHistoryScreenPreview() {
    ThemeHistoryScreen(onBack = {}, onNavigate = {})
}