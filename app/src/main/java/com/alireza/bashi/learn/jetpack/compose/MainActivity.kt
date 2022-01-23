package com.alireza.bashi.learn.jetpack.compose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alireza.bashi.learn.jetpack.compose.ui.theme.LearnJetpackComposeTheme
import com.google.accompanist.coil.rememberCoilPainter

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
            ImageExample()
        }
    }
}

@Composable
fun ImageExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .shadow(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // image bitmap
        Text(
            text = "Bitmap",
            modifier = Modifier.padding(top = 16.dp),
            fontSize = 15.sp
        )
        Image(
            painter = painterResource(id = R.drawable.compose),
            contentDescription = "Android",
            modifier = Modifier
                .width(300.dp)
                .height(160.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(10))
        )

        //image vector
//        Text(
//            text = "Vector",
//            modifier = Modifier.padding(top = 16.dp),
//            fontSize = 15.sp
//        )
//        Image(
//            painter = painterResource(id = R.drawable.vector),
//            contentDescription = "Game",
//            modifier = Modifier
//                .width(300.dp)
//                .height(200.dp)
//                .padding(16.dp)
//        )

        //image Icon
//        Text(
//            text = "Icon",
//            modifier = Modifier.padding(top = 16.dp),
//            fontSize = 15.sp
//        )
//        Icon(
//            imageVector = Icons.Outlined.Person,
//            contentDescription = "User"
//        )

        //image accompanist-coil
        Text(
            text = "accompanist coil",
            modifier = Modifier.padding(top = 16.dp),
            fontSize = 15.sp
        )

        var linkImage by remember { mutableStateOf("") }
        val painter = rememberCoilPainter(request = linkImage)
        Image(
            painter = painter,
            contentDescription = "Link",
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .padding(16.dp)
                .background(Color.Black)
                .clip(RoundedCornerShape(10))
        )
        Button(onClick = {
            linkImage = "https://static.cdn.asset.aparat.com/profile-photo/6378539-m.jpg"
        }) {
            Text(text = "Load Image")
        }

    }
}