package com.example.zukanmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zukanmobile.ui.theme.DeepTeal
import com.example.zukanmobile.ui.theme.DeepTealBlue
import com.example.zukanmobile.ui.theme.White
import com.example.zukanmobile.ui.theme.mainFont

// ================================================================================================
// 詳細画面の詳細部分コンポーネント
// ================================================================================================
@Composable
fun TitleWithDetail(
    modifier: Modifier = Modifier,
    title: String,
    detail: String
) {
    Column {
        Text(text = title, fontSize = 32.sp, fontFamily = mainFont, color = White)
        Spacer(Modifier.height(12.dp))

        Text(
            text = detail,
            fontSize = 20.sp,
            fontFamily = mainFont,
            color = White,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(Modifier.height(4.dp))

        HorizontalDivider(
            thickness = 2.dp, color = White, modifier = Modifier
                .fillMaxWidth()

        )
    }
}

@Preview
@Composable
private fun TitleWithDetailPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepTealBlue)
    ) {
        TitleWithDetail(title = "創造ID", detail = "00001")
    }
}