package com.alireza.bashi.learn.jetpack.compose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import com.alireza.bashi.learn.jetpack.compose.ui.theme.LearnJetpackComposeTheme
import kotlinx.coroutines.launch

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
            SnackBarExample()
        }
    }
}

@Composable
fun SnackBarExample() {
    val snackBarState = SnackbarHostState()
    val scaffoldState = rememberScaffoldState(snackbarHostState = snackBarState)
    val scope = rememberCoroutineScope()
    var showDialog by remember { mutableStateOf(false) }
    var bgColor by remember { mutableStateOf(Color.Blue) }

    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = bgColor,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Show SnackBar") },
                onClick = {
                    scope.launch {
                        val result = scaffoldState.snackbarHostState.showSnackbar("Hello Jetpack Compose", actionLabel = "ok")
                        if (result == SnackbarResult.ActionPerformed) showDialog = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications"
                    )
                }
            )
        }
    ) {

        if (showDialog){
            AlertDialog(
                onDismissRequest = { /*TODO*/ },
                confirmButton = { Button(onClick = {
                    bgColor = Color.Yellow
                    showDialog = false
                }) {
                    Text(text = "ok")
                }},
                dismissButton = { Button(onClick = { showDialog = false }) {
                    Text(text = "cancel")
                }},
                title = {Text(text = "AlertDialog Example") },
                text = { Text(text = "AlertDialog text") },
                properties = DialogProperties(dismissOnBackPress = false,dismissOnClickOutside = false)
            )
        }

    }
}