package com.alireza.bashi.learn.jetpack.compose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
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
@Preview(showBackground = true,showSystemUi = true,widthDp = 320,name = "DefaultPreviewLight")
@Preview(showBackground = true,uiMode = UI_MODE_NIGHT_YES,showSystemUi = true, widthDp = 320,name = "DefaultPreviewDark")
@Composable
fun DefaultPreview() {
    LearnJetpackComposeTheme {
        Text(text = "Hello Android!")
    }
}