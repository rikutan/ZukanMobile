package com.example.zukanmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zukanmobile.ui.theme.MidnightNavy
import com.example.zukanmobile.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToComponent(
    modifier: Modifier = Modifier,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    content: @Composable () -> Unit
) {
    PullToRefreshBox(
        modifier = modifier,
        isRefreshing = isRefreshing,
        onRefresh = onRefresh
    ) {
        content()
    }
}

@Preview
@Composable
private fun PullToComponentPreview() {
    PullToComponent(isRefreshing = false, onRefresh = {}) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(MidnightNavy)
                .padding(16.dp)
        ) {
            Text(text = "関数の定義方法", color = White)
        }
    }
}