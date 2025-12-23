package com.example.zukanmobile.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.zukanmobile.SharedViewModel
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
        startDestination = "list",
//        startDestination = "start",
    ) {
        // =========================================================================================
        // 01 スタート画面
        // =========================================================================================
        composable("start") {
            StartScreen { navController.navigate("list") }
        }


        // =========================================================================================
        // 02 一覧画面
        // =========================================================================================
        composable("list") {
            ListScreen(
                onClickItem = { id ->
                    navController.navigate("detail/$id")
                }
            )
        }

        navigation(
            route = "interaction",
            startDestination = "detail/{specieId}",
        ) {

            // =========================================================================================
            // 03 詳細画面
            // =========================================================================================
            composable(
                route = "detail/{specieId}",
                arguments = listOf(
                    navArgument("specieId") { type = NavType.StringType }
                )
            ) {
                val parentEntry = remember(it) {
                    navController.getBackStackEntry("interaction")
                }
                val vm: SharedViewModel = hiltViewModel(parentEntry)

                // ListScreenから受け取ったidをここで変数化して保持
                val specieId = it.arguments?.getString("specieId") ?: ""

                // キーのspecieIdが変更されるたびに新しくidを代入する
                LaunchedEffect(specieId) {
                    vm.setBaseSpecie(specieId)
                }

                DetailScreen(
                    specieId = specieId,
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


            // =====================================================================================
            // 04 交流相手選択画面
            // =====================================================================================
            composable("partnerSelect") {
                val parentEntry = remember(it) {
                    navController.getBackStackEntry("interaction")
                }
                val vm: SharedViewModel = hiltViewModel(parentEntry)

                val specieId by vm.baseSpecieId.collectAsState()

                PartnerSelectScreen(
                    specieId = specieId,
                    partnerSelectId = { partnerSpecieId ->
                        vm.setPartnerSpecie(partnerSpecieId)
                    },
                    onNavigate = { navController.navigate("themeInput") },
                    onBack = { navController.popBackStack() }
                )
            }

            // =====================================================================================
            // 05 テーマ入力画面
            // =====================================================================================
            composable("themeInput") {
                val parentEntry = remember(it) {
                    navController.getBackStackEntry("interaction")
                }
                val vm: SharedViewModel = hiltViewModel(parentEntry)

                ThemeInputScreen(
                    vm = vm,
                    onBack = { navController.popBackStack() },
                    onSend = { navController.navigate("chat") },
                )
            }
        }


        // =========================================================================================
        // 06 チャット画面
        // =========================================================================================
        composable("chat") {
            ChatScreen { navController.popBackStack() }
        }

        // =========================================================================================
        // 07 交流テーマ履歴選択画面
        // =========================================================================================
        composable("themeHistory") {
            ThemeHistoryScreen(
                onBack = { navController.popBackStack() },
                onNavigate = { navController.navigate("themeHistoryChat") },
            )
        }

        // =========================================================================================
        // 08 交流テーマチャット確認画面
        // =========================================================================================
        composable("themeHistoryChat") {
            ThemeHistoryChatScreen(
                onBack = { navController.popBackStack() },
            )
        }
    }
}