package com.alireza.bashi.learn.jetpack.compose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alireza.bashi.learn.jetpack.compose.ui.theme.LearnJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnJetpackComposeTheme {
                // تنظیم تم شب و روز نیاز به زمین داریم که کمپوز ها روش بچینیم مثل سارفیس
                Surface(color = MaterialTheme.colors.background) {
                    DefaultPreview()
                }
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
        ButtonExample()
    }
}

@Composable
fun ButtonExample() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var saveStatus by remember { mutableStateOf("Hello World") }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.LightGray)
                .padding(16.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = saveStatus,
                fontSize = 30.sp,
                modifier = Modifier.clickable { saveStatus = "Hello World" }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { saveStatus = "Clicked Button 1" },
            modifier = Modifier.padding(16.dp),
            border =  BorderStroke(2.dp, Color.White)
        ) {
            Text(text = stringResource(id = R.string.Example_Button_1))
        }

        Button(
            onClick = { saveStatus = "Clicked Button 2" },
            modifier = Modifier.padding(16.dp),
            border =  BorderStroke(2.dp, Color.Black)
        ) {
            Text(text = stringResource(id = R.string.Example_Button_2))
        }

        Button(
            onClick = { saveStatus = "Clicked Button 3" },
            modifier = Modifier.padding(16.dp),
            border =  BorderStroke(2.dp, Color.Yellow),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Unspecified)
        ) {
            Text(text = stringResource(id = R.string.Example_Button_3))
        }
    }
}