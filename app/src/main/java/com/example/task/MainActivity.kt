package com.example.task

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.example.task.navigation.Navigation
import com.example.task.ui.theme.TaskTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskTheme {
                // A surface container using the 'background' color from the theme
                val systemUiController = rememberSystemUiController()
                val isDarkTheme = isSystemInDarkTheme()
                val useDarkIcons = MaterialTheme.colors.isLight

                SideEffect {
                    if(isDarkTheme){
                        Log.d("--", "Dark ----------- ")
                        systemUiController.setSystemBarsColor(
                            darkIcons = useDarkIcons,
                            color = Color.Transparent
                        )
                    } else{
                        Log.d("--", "Light ----------- ")
                        systemUiController.setStatusBarColor(
                            darkIcons = false,
                            color = Color.Black
                        )
                    }
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val context = LocalContext.current
                    Navigation(/*context*/)
                }
            }
        }

        //making text scrollable while keyboard is on
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)){
            view, insets ->
            val bottom = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
            view.updatePadding(bottom = bottom)
            insets
        }*/
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskTheme {

    }
}