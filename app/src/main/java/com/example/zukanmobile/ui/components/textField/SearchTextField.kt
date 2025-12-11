package com.example.zukanmobile.ui.components.textField

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zukanmobile.ui.theme.DeepTealBlue
import com.example.zukanmobile.ui.theme.TropicalAqua
import com.example.zukanmobile.ui.theme.White
import com.example.zukanmobile.ui.theme.mainFont

// =================================================================================================
// 一覧画面のトップバー内で使用するテキストフィールド
// =================================================================================================
@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onClear: () -> Unit,
) {
    val inputText = 20.sp

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .border(3.dp, TropicalAqua, shape = RoundedCornerShape(100.dp))
            .padding(horizontal = 16.dp),

        maxLines = 1,
        singleLine = true,

        // アイコン
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = White.copy(0.5f),
                modifier = Modifier.size(32.dp)
            )
        },
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(onClick = onClear) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = null,
                        tint = White.copy(0.5f),
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        },

        // プレースホルダー＆テキストスタイル
        placeholder = {
            Text(
                text = "創造IDもしくは種族名で検索....",
                fontFamily = mainFont,
                fontSize = inputText,
                color = White.copy(0.5f),
            )
        },
        textStyle = TextStyle(fontSize = inputText, fontFamily = mainFont, color = White),
        colors = OutlinedTextFieldDefaults.colors(
            // コンテナ
            unfocusedContainerColor = DeepTealBlue,
            focusedContainerColor = DeepTealBlue,
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
private fun SearchTextFieldPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepTealBlue),
        contentAlignment = Alignment.Center
    ) {
        var text by remember { mutableStateOf("") }
        SearchTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.padding(horizontal = 32.dp),
            onClear = {}
        )
    }
}