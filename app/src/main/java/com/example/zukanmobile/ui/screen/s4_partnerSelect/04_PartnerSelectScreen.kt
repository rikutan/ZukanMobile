package com.example.zukanmobile.ui.screen.s4_partnerSelect

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zukanmobile.ui.components.CustomButton
import com.example.zukanmobile.ui.components.ModelViewerForPartnerSelect
import com.example.zukanmobile.ui.components.SelectImage
import com.example.zukanmobile.ui.components.TopBar
import com.example.zukanmobile.ui.theme.DeepTealBlue
import com.example.zukanmobile.ui.theme.White
import com.example.zukanmobile.ui.theme.mainFont


@Composable
fun PartnerSelectScreen(
    modifier: Modifier = Modifier,
    specieId: String?,
    partnerSelectId: (String) -> Unit,
    onBack: () -> Unit,
    onNavigate: () -> Unit,
    vm: PartnerSelectViewModel = hiltViewModel()
) {
    // ViewModelから取得した変数 ======================================================================
    val specieList by vm.specieList.collectAsState()
    val selectedSpecie by vm.selectedSpecie.collectAsState()
    // =============================================================================================

    LaunchedEffect(specieId) {
        vm.loadPartnerCandidates(specieId)
    }

    Scaffold(
        containerColor = DeepTealBlue,
        topBar = { TopBar(title = "", onBack = onBack) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(32.dp))

            // SceneView ---------------------------------------------------------------------------
            ModelViewerForPartnerSelect(
                modifier = Modifier.padding(horizontal = 16.dp),
                height = 250.dp,
                modelPath = "models/model1.glb"
            )
            Text(
                text = selectedSpecie?.name ?: "",
                color = White,
                fontFamily = mainFont,
                fontSize = 28.sp,
                modifier = Modifier.padding(vertical = 20.dp)
            )


            // 画像選択 -----------------------------------------------------------------------------
            HorizontalDivider(thickness = 2.dp, color = White, modifier = Modifier.fillMaxWidth())

            LazyRow(
                modifier = Modifier.padding(vertical = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item { Spacer(Modifier.width(4.dp)) }

                items(specieList) { item ->
                    SelectImage(
                        size = 100.dp,
                        model = item.imageUrl ?: "",
                        isSelected = selectedSpecie?.id == item.id
                    ) {
                        vm.onSpecieSelected(item)
                    }
                }

                item { Spacer(Modifier.width(4.dp)) }
            }

            HorizontalDivider(thickness = 2.dp, color = White, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(32.dp))


            // ボタン -------------------------------------------------------------------------------
            CustomButton(
                modifier = Modifier.padding(horizontal = 40.dp),
                buttonText = "決定",
            ) {
                selectedSpecie?.let {
                    partnerSelectId(it.id)
                    onNavigate()
                }
            }
        }
    }
}

//@Preview
//@Composable
//private fun PartnerSelectScreenPreview() {
//    PartnerSelectScreen(partnerSelectId = {}, onNavigate = {}, onBack = {})
//}