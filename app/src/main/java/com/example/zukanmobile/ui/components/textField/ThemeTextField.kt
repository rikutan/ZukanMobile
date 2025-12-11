package com.example.zukanmobile.ui.components.textField

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zukanmobile.ui.theme.MidnightNavy
import com.example.zukanmobile.ui.theme.TropicalAqua
import com.example.zukanmobile.ui.theme.White
import com.example.zukanmobile.ui.theme.mainFont

@Composable
fun ThemeTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    height: Dp,
) {

    val inputText = 20.sp
    val shape = 16.dp

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(shape = RoundedCornerShape(shape))
            .border(2.dp, TropicalAqua, shape = RoundedCornerShape(shape)),

        // プレースホルダー＆テキストスタイル
        placeholder = {
            Text(
                text = "テーマを入力してください",
                fontFamily = mainFont,
                fontSize = inputText,
                color = White.copy(0.3f),
            )
        },
        textStyle = TextStyle(fontSize = inputText, fontFamily = mainFont, color = White),
        colors = OutlinedTextFieldDefaults.colors(
            // コンテナ
            unfocusedContainerColor = MidnightNavy,
            focusedContainerColor = MidnightNavy,
            // 枠線
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            // カーソル
            cursorColor = TropicalAqua
        )
    )
}

@Preview
@Composable
private fun ThemeTextFieldPreview() {
    ThemeTextField(value = "", onValueChange = {}, height = 200.dp)
}