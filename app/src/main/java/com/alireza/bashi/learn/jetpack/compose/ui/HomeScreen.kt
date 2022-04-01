package com.alireza.bashi.learn.jetpack.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.alireza.bashi.learn.jetpack.compose.navigation.Screen
import com.alireza.bashi.learn.jetpack.compose.ui.theme.DeepBlue

@Composable
fun HomeScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.Detail.route){
                    // اگر بخوایم این صفحه پاک بشه مثلا برای اسپلش اسکرین بعد رفتن به صفحه بعدی بر نگرده
                    popUpTo(Screen.Home.route){
//                        inclusive = true
                    }
                }
            },
            text = "Home",
            color = Color.White,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Home",
            color = Color.White,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}