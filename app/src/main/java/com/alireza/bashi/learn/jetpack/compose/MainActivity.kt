package com.alireza.bashi.learn.jetpack.compose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
@Preview(showBackground = true, showSystemUi = true, widthDp = 320, name = "DefaultPreviewLight")
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    showSystemUi = true,
    widthDp = 320,
    name = "DefaultPreviewDark"
)
@Composable
fun DefaultPreview() {
    LearnJetpackComposeTheme {
        TextSample()
    }
}

@Composable
fun MyBox() {
    // داخل box میشه کمپوز هارو رویه هم قرار داد
    Box(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
            .background(Color.Yellow)
    ) {
        // اینجا کمپوز های که رویه هم میخوای قرار بگیرن میزاری
    }


}

@Composable
fun MyColumn() {
    // میتونیم با این کالم کمپوز هارو عمودی کنار هم چید
    // اینجا گفتیم هوریزنتالت وسط باشه
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        MyBox()
        MyBox()
        MyBox()
    }
}

@Composable
fun MyRow() {
    //  بصورت افقی کمپوز هارو کنار هم میچینه
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        MyBox()
        MyBox()
        MyBox()
    }
}

@Composable
fun TextSample() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var input by remember { mutableStateOf("") }

        Text(text = "Hello Android!")
        Text(
            text = "Hello Android!",
            style = TextStyle.Default.copy(color = Color.Black  /*textDirection = TextDirection.Ltr , fontStyle ,fontSize*/  )
        )
        BasicText(text = "Hello Android")

        TextField(
            value = input,
            onValueChange = { text -> input = text },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(2.dp, Color.Black),
            label = { Text(text = "name",style = TextStyle.Default.copy(color = Color.Black)) }
        )

    }
}