package com.alireza.bashi.learn.jetpack.compose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alireza.bashi.learn.jetpack.compose.ui.theme.LearnJetpackComposeTheme
import kotlinx.coroutines.launch

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
            ExampleDrawerMenu()
        }
    }
}

@Composable
fun ExampleDrawerMenu() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, start = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.alireza),
                contentDescription = "Alireza Bashi",
                modifier = Modifier
                    .size(130.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .border(2.dp, Color.Black),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "AlirezaBashi98",
                fontSize = 20.sp
            )
            Text(
                text = "AlirezaBashi98@gmail.com",
                fontSize = 15.sp,
            )

            Divider(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                color = Color.Black
            )

            val menu = mapOf(
                "Home" to Icons.Default.Home,
                "Settings" to Icons.Default.Settings,
                "About" to Icons.Default.Info,
            )
            for ((name, icon) in menu)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = name,
                    )
                    Text(
                        text = name,
                        modifier = Modifier.padding(start = 8.dp, top = 3.dp)
                    )
                }

            Divider(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                color = Color.Black
            )

            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable {
                        scope.launch {
                            drawerState.close()
                        }
                    }
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close Menu"
                )
                Text(
                    text = "Close Menu",
                    modifier = Modifier
                        .padding(start = 8.dp, top = 3.dp)
                        .align(alignment = Alignment.CenterVertically)
                )
            }

        }
    },
    drawerBackgroundColor = Color.White,
    drawerContentColor = Color.Black,
    gesturesEnabled = true) {
        Column {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}