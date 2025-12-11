package com.example.zukanmobile.ui.screen.AR

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zukanmobile.ui.components.BackButton
import dev.romainguy.kotlin.math.Float4
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.rememberARCameraNode
import io.github.sceneview.math.Position
import io.github.sceneview.math.Rotation
import io.github.sceneview.math.Scale
import io.github.sceneview.node.ModelNode
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberEnvironmentLoader
import io.github.sceneview.rememberMainLightNode
import io.github.sceneview.rememberModelLoader

@Composable
fun ARScreen(modifier: Modifier = Modifier, onBack: () -> Unit) {
    val engine = rememberEngine()
    val modelLoader = rememberModelLoader(engine)
    val environmentLoader = rememberEnvironmentLoader(engine)
    val environment = remember {
        environmentLoader.createHDREnvironment(
            "environments/sample.hdr"
        ) ?: error("エラー")
    }
    val mainLight = rememberMainLightNode(engine).apply {
        intensity = 200_000f
        color = Float4(1f, 1f, 1f, 1f)
        rotation = Rotation(45f, 0f, 0f)
    }

    val modelNode = remember {
        val fileName = "models/model3.glb"
        val instance = modelLoader.createModelInstance(fileName)
        ModelNode(modelInstance = instance).apply {
            scale = Scale(3f)
            position = Position(0f, -5f, -10f)
        }
    }

    Box() {
        ARScene(
            modifier = Modifier.fillMaxSize(),
            engine = engine,
            environment = environment,
            cameraNode = rememberARCameraNode(engine),
            mainLightNode = mainLight,
            childNodes = listOf(
                modelNode,
                mainLight
            ),

            )
        BackButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 24.dp, top = 40.dp),
            boxSize = 52.dp,
            iconSize = 24.dp
        ) { onBack() }
    }
}