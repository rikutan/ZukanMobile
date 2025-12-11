package com.example.zukanmobile.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.zukanmobile.ui.theme.MidnightNavy
import com.example.zukanmobile.ui.theme.TropicalAqua
import com.example.zukanmobile.util.toSkyboxColor
import com.google.android.filament.Skybox
import io.github.sceneview.Scene
import io.github.sceneview.math.Position
import io.github.sceneview.math.Scale
import io.github.sceneview.node.ModelNode
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberModelLoader
import io.github.sceneview.rememberNodes


// ================================================================================================
// 詳細画面のモデル表示コンポーネント
// ================================================================================================
@Composable
fun ModelViewer(modelPath: String, onBack: () -> Unit) {
    val shape = 20.dp

    val engine = rememberEngine()
    val modelLoader = rememberModelLoader(engine)

    val modelInstance = remember(modelPath) {
        modelLoader.createModelInstance(modelPath)
    }
    val modelNode = ModelNode(
        modelInstance = modelInstance
    ).apply {
        scale = Scale(0.25f)
        position = Position(0f, -0.2f, 0f)
    }


    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Scene(
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp)
                .clip(RoundedCornerShape(shape))
                .border(1.dp, TropicalAqua, shape = RoundedCornerShape(shape)),
            engine = engine,
            modelLoader = modelLoader,
            onViewCreated = {

                this.clipToOutline = true
                this.scene.skybox =
                    Skybox.Builder()
                        .color(MidnightNavy.toSkyboxColor())
                        .build(this.engine)
            },
            childNodes = rememberNodes {
                add(modelNode)
            })

        BackButton(
            boxSize = 52.dp,
            iconSize = 24.dp,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            onBack()
        }
    }
}

// パートナー選択画面表示コンポーネント
@Composable
fun ModelViewerForPartnerSelect(modifier: Modifier, height: Dp, modelPath: String) {
    val shape = 20.dp

    val engine = rememberEngine()
    val modelLoader = rememberModelLoader(engine)

    val modelInstance = remember {
        modelLoader.createModelInstance(modelPath)
    }
    val modelNode = ModelNode(
        modelInstance = modelInstance
    ).apply {
        scale = Scale(0.3f)
        position = Position(0f, -0.2f, 0f)
    }


    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Scene(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .clip(RoundedCornerShape(shape))
                .border(1.dp, TropicalAqua, shape = RoundedCornerShape(shape)),
            engine = engine,
            modelLoader = modelLoader,
            onViewCreated = {
                this.clipToOutline = true
                this.scene.skybox =
                    Skybox.Builder()
                        .color(MidnightNavy.toSkyboxColor())
                        .build(this.engine)
            },
            childNodes = rememberNodes {
                add(modelNode)
            }
        )
    }
}


@Preview
@Composable
private fun ModelViewerPreview() {
//    ModelViewer(onBack = {})
}