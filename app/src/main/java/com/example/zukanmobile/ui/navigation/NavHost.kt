package com.example.zukanmobile.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zukanmobile.ui.screen.AR.ARScreen
import com.example.zukanmobile.ui.screen.s1_start.StartScreen
import com.example.zukanmobile.ui.screen.s2_list.ListScreen
import com.example.zukanmobile.ui.screen.s3_detail.DetailScreen
import com.example.zukanmobile.ui.screen.s4_partnerSelect.PartnerSelectScreen
import com.example.zukanmobile.ui.screen.s5_themeInput.ThemeInputScreen
import com.example.zukanmobile.ui.screen.s6_chat.ChatScreen
import com.example.zukanmobile.ui.screen.s7_themeHistory.ThemeHistoryScreen
import com.example.zukanmobile.ui.screen.s8_themeHistoryChat.ThemeHistoryChatScreen

@Composable
fun NavHostRouter() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "start",
    ) {
        // 01 スタート画面 ===========================================================================
        composable("start") {
            StartScreen { navController.navigate("list") }
        }


        // 02 一覧画面 ==============================================================================
        composable("list") {
            ListScreen(
                onClickItem = { id ->
                    navController.navigate("detail/$id")
                }
            )
        }


        // 03 詳細画面 ==============================================================================
        composable(
            route = "detail/{specieId}",
        ) {
            DetailScreen(
                onBack = { navController.popBackStack() },
                onNavigateAR = { navController.navigate("ar") },
                onNavigatePartnerSelect = { navController.navigate("partnerSelect") },
                onNavigateThemeHistory = { navController.navigate("themeHistory") },
            )
        }
        // 詳細画面から遷移するAR画面
        composable("ar") {
            ARScreen(onBack = { navController.popBackStack() })
        }


        // 04 交流相手選択画面 ========================================================================
        composable("partnerSelect") {
            PartnerSelectScreen(
                onNavigate = { navController.navigate("themeInput") },
                onBack = { navController.popBackStack() }
            )
        }


        // 05 テーマ入力画面 =========================================================================
        composable("themeInput") {
            ThemeInputScreen(
                onBack = { navController.popBackStack() },
                onSend = { navController.navigate("chat") },
            )
        }


        // 06 チャット画面  ==========================================================================
        composable("chat") {
            ChatScreen { navController.popBackStack() }
        }


        // 07 交流テーマ履歴選択画面 ===================================================================
        composable("themeHistory") {
            ThemeHistoryScreen(
                onBack = { navController.popBackStack() },
                onNavigate = { navController.navigate("themeHistoryChat") },
            )
        }


        // 08 交流テーマチャット確認画面 ================================================================
        composable("themeHistoryChat") {
            ThemeHistoryChatScreen(
                onBack = { navController.popBackStack() },
            )
        }
    }
}