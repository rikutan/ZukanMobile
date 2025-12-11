package com.example.zukanmobile

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.example.zukanmobile.firebase.remote.SpecieRemoteDataSource
import com.example.zukanmobile.ui.navigation.NavHostRouter
import com.example.zukanmobile.ui.theme.ZukanMobileTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZukanMobileTheme {
                NavHostRouter()
            }
        }
    }
}
