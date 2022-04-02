package com.alireza.bashi.learn.jetpack.compose

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.compose.rememberNavController
import com.alireza.bashi.learn.jetpack.compose.navigation.SetupNavGraph
import com.alireza.bashi.learn.jetpack.compose.ui.theme.LearnJetpackComposeTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "counter")
    val KEY = stringPreferencesKey("keys")
    lateinit var stext : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {

            dataStore.edit {
                it[KEY] = "Text Test"
            }

            val text: Flow<String> = dataStore.data.map { data ->
                data[KEY] ?: "Default value" // if the data is null we'll get the "Default value" text
            }

            text.collect { data ->
                stext = data
            }

        }
        setContent { DefaultPreview(stext?:"null") }

    }
}

//    device = Devices.PIXEL_4_XL
//    showSystemUi = true
//    uiMode = UI_MODE_NIGHT_YES
//    name = "DefaultPreviewDark"
@ExperimentalFoundationApi
//@Preview(showBackground = true)
//@Preview(
//    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    name = "DefaultPreviewDark"
//)
@Composable
private fun DefaultPreview(text:String) {

    val navController = rememberNavController()

    LearnJetpackComposeTheme {
        // تنظیم تم شب و روز نیاز به زمین داریم که کمپوز ها روش بچینیم مثل سارفیس
        Surface(color = MaterialTheme.colors.background) {

//            SetupNavGraph(navController = navController)
            Text(text = text)
        }
    }
}

