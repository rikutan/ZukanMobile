package com.example.zukanmobile.ui.screen.s1_start

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zukanmobile.ui.theme.DeepTealBlue
import com.example.zukanmobile.ui.theme.TropicalAqua
import com.example.zukanmobile.ui.theme.White
import com.example.zukanmobile.ui.theme.mainFont

@Composable
fun StartScreen(onNavigate: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepTealBlue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("ARみらい空想種族図鑑", color = White, fontSize = 40.sp, fontFamily = mainFont)
        Spacer(Modifier.height(100.dp))

        Button(
            onClick = onNavigate,
            modifier = Modifier
                .width(250.dp)
                .border(3.dp, TropicalAqua, shape = RoundedCornerShape(12.dp)),
            contentPadding = PaddingValues(vertical = 16.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = White.copy(0.01f),
            )
        ) {
            Text(
                "図鑑を開く",
                fontSize = 28.sp,
                fontFamily = mainFont,
                color = White
            )
        }
    }
}

@Preview
@Composable
private fun StartScreenPreview() {
    StartScreen(onNavigate = {})
}