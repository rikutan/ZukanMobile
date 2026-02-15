package com.example.zukanmobile.ui.screen.s6_chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zukanmobile.R
import com.example.zukanmobile.SharedViewModel
import com.example.zukanmobile.ui.components.ChatSpeechBubbleLeft
import com.example.zukanmobile.ui.components.ChatSpeechBubbleRight
import com.example.zukanmobile.ui.components.TopBar
import com.example.zukanmobile.ui.theme.DeepTealBlue
import com.example.zukanmobile.ui.theme.MidnightNavy

@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    vm: ChatViewModel = hiltViewModel(),
    sharedVm: SharedViewModel,
    onBack: () -> Unit
) {
    // ViewModelから取得した変数 ======================================================================
    val message by vm.messages.collectAsState()
    val specieId by sharedVm.baseSpecieId.collectAsState()
    val partnerId by sharedVm.partnerSpecieId.collectAsState()
    val theme by sharedVm.theme.collectAsState()
    // =============================================================================================
    val size = 50.dp

    LaunchedEffect(specieId, partnerId, theme) {
        if (specieId?.isNotBlank() == true && partnerId?.isNotBlank() == true && theme?.isNotBlank() == true) {
            vm.startChat(
                specieId = specieId!!,
                partnerId = partnerId!!,
                theme = theme!!
            )
        }
    }
    Scaffold(
        containerColor = DeepTealBlue,
        topBar = {
            TopBar(title = "", onBack = onBack)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MidnightNavy)
                .padding(paddingValues)
                .padding(horizontal = 8.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Spacer(Modifier.height(20.dp))

            message.forEach { msg ->
                if (msg.isFromSelf) {
                    ChatSpeechBubbleLeft(
                        image = R.drawable.t_00001,
                        name = msg.speakerName,
                        chatText = msg.message,
                        size = size
                    )
                } else {
                    ChatSpeechBubbleRight(
                        image = R.drawable.t_00001,
                        name = msg.speakerName,
                        chatText = msg.message,
                        modifier = Modifier.align(Alignment.End),
                        size = size
                    )
                }
            }


//            ChatSpeechBubbleLeft(
//                image = R.drawable.t_00001,
//                name = "ありが",
//                chatText = "hello",
//                size = size
//            )
//            ChatSpeechBubbleRight(
//                image = R.drawable.t_00001,
//                name = "あかお",
//                chatText = "hello",
//                modifier = Modifier.align(Alignment.End),
//                size = size
//            )
        }
    }
}

//@Preview
//@Composable
//private fun ChatScreenPreview() {
//    ChatScreen(onBack = {})
//}