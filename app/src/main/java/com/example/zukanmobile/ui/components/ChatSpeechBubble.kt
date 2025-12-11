package com.example.zukanmobile.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zukanmobile.R
import com.example.zukanmobile.ui.theme.DeepTealBlue
import com.example.zukanmobile.ui.theme.MidnightNavy
import com.example.zukanmobile.ui.theme.TropicalAqua
import com.example.zukanmobile.ui.theme.White
import com.example.zukanmobile.ui.theme.mainFont

// 左側に配置をする吹き出しコンポーネント
@Composable
fun ChatSpeechBubbleLeft(
    modifier: Modifier = Modifier,
    image: Int,
    name: String,
    chatText: String,
    size: Dp,
) {

    Row(modifier = modifier) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .border(2.dp, TropicalAqua, shape = CircleShape)
                .size(size)
        )
        Spacer(Modifier.width(8.dp))

        Column {
            Text(
                text = name,
                color = White,
                fontSize = 20.sp,
                fontFamily = mainFont,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .widthIn(max = 230.dp)
                    .padding(vertical = 4.dp)
            )
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .widthIn(max = 230.dp)
                    .border(
                        2.dp, TropicalAqua,
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                Text(
                    text = chatText,
                    color = White,
                    fontFamily = mainFont,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                        .offset(x = 3.dp)
                )
            }
        }
    }
}

// 右側に配置するコンポーネント
@Composable
fun ChatSpeechBubbleRight(
    modifier: Modifier = Modifier,
    image: Int,
    name: String,
    chatText: String,
    size: Dp
) {

    Row(modifier = modifier) {

        Column {
            Text(
                text = name,
                color = White,
                fontSize = 20.sp,
                fontFamily = mainFont,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .widthIn(max = 230.dp)
                    .padding(vertical = 4.dp)
                    .align(Alignment.End)
            )
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .widthIn(max = 230.dp)
                    .align(Alignment.End)
                    .border(
                        2.dp, TropicalAqua,
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                Text(
                    text = chatText,
                    color = White,
                    fontFamily = mainFont,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                        .offset(x = 3.dp)
                )
            }
        }
        Spacer(Modifier.width(8.dp))

        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .border(2.dp, TropicalAqua, shape = CircleShape)
                .size(size)
        )
    }
}

@Preview
@Composable
private fun ChatSpeechBubblePreview() {
    Scaffold(
        containerColor = DeepTealBlue,
        topBar = {
            TopBar(title = "", onBack = {})
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
            val size = 50.dp

            ChatSpeechBubbleLeft(
                image = R.drawable.t_00001,
                name = "ありが",
                chatText = "hellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohello",
                size = size
            )
            ChatSpeechBubbleRight(
                image = R.drawable.t_00001,
                name = "あかお",
                chatText = "hellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohello",
                modifier = Modifier.align(Alignment.End),
                size = size
            )
        }
    }
}


