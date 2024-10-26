package com.example.composelottie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.composelottie.ui.theme.ComposeLottieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLottieTheme {
                val composition by rememberLottieComposition(
                    spec = LottieCompositionSpec.Asset("anim.json")
                )
                val isPlaying = remember {
                    mutableStateOf(false)
                }
                val isComplete = remember {
                    mutableStateOf(false)
                }
                val animSpec = LottieClipSpec.Progress(
                    0f,
                    if (isComplete.value) 1f else 0.5f
                )

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    LottieAnimation(
                        composition = composition,
                        isPlaying = isPlaying.value,
                        modifier = Modifier.size(200.dp),
                        speed = 1f,
                        iterations = if(isComplete.value) 1 else LottieConstants.IterateForever,
                        reverseOnRepeat = true,
                        clipSpec = animSpec
                    )
                    Button(
                        onClick = {
                            isPlaying.value = !isPlaying.value
                        }) {
                            Text(text = "Download")
                    }
                    Button(
                        onClick = {
                            isComplete.value = !isComplete.value
                        }) {
                            Text(text = "Finish")
                    }
                    Button(
                        onClick = {
                            isPlaying.value = !isPlaying.value
                        }) {
                        Text(text = "Restart")
                    }
                }
            }
        }
    }
}
