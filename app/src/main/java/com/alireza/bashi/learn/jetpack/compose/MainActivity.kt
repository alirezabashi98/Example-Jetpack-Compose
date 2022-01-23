package com.alireza.bashi.learn.jetpack.compose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alireza.bashi.learn.jetpack.compose.ui.theme.LearnJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnJetpackComposeTheme {
                DefaultPreview()
            }
        }
    }
}

//    device = Devices.PIXEL_4_XL
//    showSystemUi = true
//    uiMode = UI_MODE_NIGHT_YES
//    name = "DefaultPreviewDark"
@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Composable
fun DefaultPreview() {
    LearnJetpackComposeTheme {
        // تنظیم تم شب و روز نیاز به زمین داریم که کمپوز ها روش بچینیم مثل سارفیس
        Surface(color = MaterialTheme.colors.background) {
            CustomGraphic()
        }
    }
}

@Composable
fun CustomGraphic() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(200.dp)
                .background(Color.LightGray)
        ) {
            drawLine(
                color = Color.Yellow,
                start = Offset(0f, size.height),
                end = Offset(size.width, 0f),
                strokeWidth = 3f
            )
        }

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(200.dp)
                .background(Color.LightGray)
        ) {
            drawCircle(
                color = Color.Blue,
                radius = 80f
            )
        }
//
//        Canvas(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//                .height(200.dp)
//                .background(Color.LightGray)
//        ) {
//            drawRect(
//                color = Color.Red,
//                topLeft = Offset(15f,15f),
//                size = Size(400f,100f)
//            )
//        }
//
//        Canvas(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(8.dp)
//                .background(Color.LightGray)
//        ) {
//            rotate(
//                45f
//            ) {
//                drawLine(
//                    color = Color.Yellow,
//                    start = Offset(0f, size.height),
//                    end = Offset(size.width, 0f),
//                    strokeWidth = 3f
//                )
//            }
//        }
//
//        Canvas(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(8.dp)
//                .background(Color.LightGray)
//        ) {
//            translate(
//                left = 100f,
//                top = 100f
//            ) {
//                drawCircle(
//                    color = Color.Blue,
//                    radius = 80f
//                )
//            }
//        }

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .background(Color.LightGray)
        ) {
            scale(0.5f) {
                drawCircle(
                    color = Color.Blue,
                    radius = 80f
                )
            }
        }

    }
}