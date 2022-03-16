package com.alireza.bashi.learn.jetpack.compose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.alireza.bashi.learn.jetpack.compose.ui.theme.LearnJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
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
            ExampleConstraintLayout2()
        }
    }
}

@Composable
fun ExampleConstraintLayout() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (button, text) = createRefs()

        val guideLineStart = createGuidelineFromStart(0.5f)

        Button(onClick = { /*TODO*/ }, Modifier.constrainAs(button) {
            top.linkTo(parent.top, margin = 16.dp)
            start.linkTo(parent.start, margin = 16.dp)
        }) {
            Text(text = "Button")
        }
        Text(text = "text", Modifier.constrainAs(text) {
            top.linkTo(button.bottom)
            start.linkTo(guideLineStart)
        })
    }
}

@Composable
fun ExampleConstraintLayout2() {
    val constrains = ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        val guidLineStart = createGuidelineFromStart(0.5f)

        constrain(button) {
            top.linkTo(parent.top, margin = 16.dp)
            start.linkTo(parent.start, margin = 16.dp)
        }

        constrain(text) {
            top.linkTo(button.bottom)
            start.linkTo(guidLineStart)
        }

    }

    ConstraintLayout(constrains, Modifier.fillMaxSize()) {
        Button(onClick = { /*TODO*/ }, Modifier.layoutId("button")) {
            Text(text = "button 2")
        }
        Text(text = "text 2", Modifier.layoutId("text"))
    }
}
