package com.example.constrainlayoutlessony

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.constrainlayoutlessony.ui.theme.ConstrainLayoutLessonYTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConstrainLayoutLessonYTheme {
                GreetingPreview()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()){
        val (text, button, image) = createRefs()
        val bottomGuideLine = createGuidelineFromBottom(0.2f)

        Button(onClick = {

        },
            modifier = Modifier.constrainAs(button){
                bottom.linkTo(bottomGuideLine)
                top.linkTo(bottomGuideLine)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            }
        ) {
            Text(text = "Click me")
        }
        Text(
            text = "Hello world",
            modifier = Modifier.constrainAs(text){
                bottom.linkTo(button.top, 16.dp)
                start.linkTo(button.start, 16.dp)
                end.linkTo(button.end, 16.dp)
            }
        )
        Image(painter = painterResource(id = R.drawable.thanos),
            contentDescription = "bla",
            modifier = Modifier.constrainAs(image){
                bottom.linkTo(text.top, 16.dp)
                start.linkTo(button.start)
                end.linkTo(button.end)
            }
                .size(300.dp))
    }
}




