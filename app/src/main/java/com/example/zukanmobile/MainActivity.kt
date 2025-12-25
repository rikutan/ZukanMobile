package com.example.zukanmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.zukanmobile.gemini.GeminiViewModel
import com.example.zukanmobile.ui.navigation.NavHostRouter
import com.example.zukanmobile.ui.theme.ZukanMobileTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val geminiVm: GeminiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        geminiVm.test()

        enableEdgeToEdge()
        setContent {
            ZukanMobileTheme {
                NavHostRouter()
            }
        }
    }
}
