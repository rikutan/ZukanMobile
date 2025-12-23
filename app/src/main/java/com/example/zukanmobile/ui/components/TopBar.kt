package com.example.zukanmobile.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zukanmobile.ui.components.textField.SearchTextField
import com.example.zukanmobile.ui.theme.DeepTeal
import com.example.zukanmobile.ui.theme.DeepTealBlue
import com.example.zukanmobile.ui.theme.White
import com.example.zukanmobile.ui.theme.mainFont

// =================================================================================================
// 検索バーと統合したトップバー
// =================================================================================================
@Composable
fun SearchTopBar(
    modifier: Modifier = Modifier,
    query: String,
    onValueChange: (String) -> Unit,
    onClear: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SearchTextField(
            value = query,
            onValueChange = onValueChange,
            onClear = onClear,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
        )
        HorizontalDivider(thickness = 3.dp, color = DeepTeal)
    }
}

// =================================================================================================
// トップバー
// =================================================================================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String, onBack: () -> Unit) {
    Column {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = DeepTealBlue,
                titleContentColor = White
            ),
            title = {
                Text(
                    text = title,
                    fontFamily = mainFont,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            navigationIcon = {
                BackButton(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    boxSize = 44.dp,
                    iconSize = 24.dp
                ) { onBack() }
            }
        )
        HorizontalDivider(thickness = 2.dp, color = DeepTeal)
    }
}


@Preview(showSystemUi = true)
@Composable
private fun TopBarPreview() {
    Scaffold(
        topBar = { TopBar(title = "あああああ", onBack = {}) },
        containerColor = DeepTealBlue
    ) {
        Text("kakak", modifier = Modifier.padding(it))
    }
}