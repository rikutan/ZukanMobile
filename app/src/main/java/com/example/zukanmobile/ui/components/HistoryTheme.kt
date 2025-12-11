package com.example.zukanmobile.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zukanmobile.ui.theme.MidnightNavy
import com.example.zukanmobile.ui.theme.TropicalAqua
import com.example.zukanmobile.ui.theme.White
import com.example.zukanmobile.ui.theme.mainFont

@Composable
fun HistoryTheme(modifier: Modifier = Modifier, height: Dp, onClick: () -> Unit) {
    val shape = 12.dp

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .border(1.dp, TropicalAqua, shape = RoundedCornerShape(shape))
            .clip(RoundedCornerShape(shape)),
        colors = CardDefaults.cardColors(containerColor = MidnightNavy),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "明日の天気について",
                color = White,
                fontFamily = mainFont,
                fontSize = 24.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = White
            )
        }
    }
}

@Preview
@Composable
private fun HistoryThemePreview() {
    HistoryTheme(height = 64.dp) {}
}