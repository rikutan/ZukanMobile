package com.example.zukanmobile.ui.screen.s3_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zukanmobile.ui.components.CustomButton
import com.example.zukanmobile.ui.components.ModelViewer
import com.example.zukanmobile.ui.components.TitleWithDetail
import com.example.zukanmobile.ui.theme.DeepTealBlue
import com.example.zukanmobile.ui.theme.MidnightNavy
import com.example.zukanmobile.ui.theme.TropicalAqua

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    vm: DetailViewModel = hiltViewModel(),
    specieId: String,
    onBack: () -> Unit,
    onNavigateAR: () -> Unit,
    onNavigatePartnerSelect: () -> Unit,
    onNavigateThemeHistory: () -> Unit,
) {
    val specieDetail by vm.specie.collectAsState()
    var changeText by remember { mutableStateOf(false) }

    Scaffold(containerColor = DeepTealBlue) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            // モデル表示部分
            ModelViewer(modelPath = "models/model1.glb") { onBack() }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                // 詳細表示
                Column(
                    modifier = Modifier
                        .background(MidnightNavy, shape = RoundedCornerShape(20.dp))
                        .border(1.dp, TropicalAqua, shape = RoundedCornerShape(20.dp))
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    TitleWithDetail(title = "創造ID", detail = specieDetail?.id ?: "")
                    TitleWithDetail(title = "種族名", detail = specieDetail?.speciesName ?: "")
                    TitleWithDetail(
                        title = "特徴",
                        detail = specieDetail?.feature ?: ""
                    )
                }

                // ボタン群
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        CustomButton(
                            buttonText = "召喚する",
                            modifier = Modifier.weight(1f)
                        ) { onNavigateAR() }

//                        // アニメーション制御のボタン
//                        PlayAnimationButton(
//                            buttonText = if (changeText) "アニメーションON" else "アニメーションOFF",
//                            modifier = Modifier.weight(1f)
//                        ) { changeText = !changeText }
                    }

                    // 各画面に遷移するボタン
                    CustomButton(buttonText = "他種族と交流する") { onNavigatePartnerSelect() }
                    CustomButton(buttonText = "交流履歴を確認") { onNavigateThemeHistory() }
                }
            }
        }
    }
}

@Preview
@Composable
private fun DetailScreenPreview() {
    DetailScreen(
        specieId = "",
        onBack = {},
        onNavigateAR = {},
        onNavigatePartnerSelect = {},
        onNavigateThemeHistory = {}
    )
}