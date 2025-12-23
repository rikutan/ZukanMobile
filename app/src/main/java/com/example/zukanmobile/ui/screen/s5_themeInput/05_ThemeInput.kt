package com.example.zukanmobile.ui.screen.s5_themeInput

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zukanmobile.SharedViewModel
import com.example.zukanmobile.ui.components.CustomButton
import com.example.zukanmobile.ui.components.TopBar
import com.example.zukanmobile.ui.components.textField.ThemeTextField
import com.example.zukanmobile.ui.theme.DeepTealBlue
import com.example.zukanmobile.ui.theme.White
import com.example.zukanmobile.ui.theme.mainFont

@Composable
fun ThemeInputScreen(
    modifier: Modifier = Modifier,
    vm: SharedViewModel,
    onBack: () -> Unit,
    onSend: () -> Unit
) {
    val focusManager = LocalFocusManager.current

    // ViewModel から取得した変数 =====================================================================
    val baseSpecieId by vm.baseSpecieId.collectAsState()
    val partnerSelectId by vm.partnerSpecieId.collectAsState()
    val theme by vm.theme.collectAsState()
    // =============================================================================================


    Scaffold(
        modifier = Modifier.clickable(
            onClick = { focusManager.clearFocus() },
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ),
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

            Text(
                text = "sID:$baseSpecieId",
                color = White,
                fontFamily = mainFont,
                fontSize = 28.sp
            )
            Text(
                text = "pID:$partnerSelectId",
                color = White,
                fontFamily = mainFont,
                fontSize = 28.sp
            )

            ThemeTextField(
                value = theme ?: "",
                onValueChange = { theme ->
                    vm.setTheme(theme)
                },
                height = 240.dp,
                modifier = Modifier.padding(vertical = 36.dp)
            )

            CustomButton(buttonText = "送信") {
                onSend()
            }
        }
    }
}

//@Preview
//@Composable
//private fun ThemeInputPreview() {
//    ThemeInputScreen(partnerSpecieId = "", onBack = {}, onSend = {})
//}