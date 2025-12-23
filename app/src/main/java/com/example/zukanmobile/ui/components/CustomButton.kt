package com.example.zukanmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zukanmobile.R
import com.example.zukanmobile.ui.theme.MidnightNavy
import com.example.zukanmobile.ui.theme.SilverBlue
import com.example.zukanmobile.ui.theme.SlateBlue
import com.example.zukanmobile.ui.theme.TropicalAqua
import com.example.zukanmobile.ui.theme.White
import com.example.zukanmobile.ui.theme.mainFont

// =================================================================================================
// 色んな画面で使用するボタンをまとめたコンポーネント
// =================================================================================================
@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .border(1.dp, TropicalAqua, shape = RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = ButtonDefaults.buttonColors(
            containerColor = MidnightNavy
        ),
    ) { Text(text = buttonText, color = White, fontFamily = mainFont, fontSize = 20.sp) }
}

// アニメーションの切り替えをするボタン ------------------------------------------------------------------
@Composable
fun PlayAnimationButton(modifier: Modifier = Modifier, buttonText: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier
            .border(1.dp, TropicalAqua, shape = RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = ButtonDefaults.buttonColors(
            containerColor = MidnightNavy
        )
    ) { Text(text = buttonText, color = White, fontFamily = mainFont, fontSize = 20.sp) }
}

// 戻るボタン ----------------------------------------------------------------------------------------
@Composable
fun BackButton(
    modifier: Modifier,
    boxSize: Dp,
    iconSize: Dp,
    onBack: () -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .clickable(
                onClick = { onBack() },
                interactionSource = interactionSource,
                indication = ripple()
            )
            .size(boxSize)
            .background(SlateBlue, shape = CircleShape)
            .clip(CircleShape)
            .border(3.dp, SilverBlue, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.arrow_back),
            contentDescription = null,
            tint = SilverBlue,
            modifier = Modifier
                .offset(x = (-2).dp)
                .size(iconSize)
        )
    }
}

@Preview
@Composable
private fun CustomButtonPreview() {
}