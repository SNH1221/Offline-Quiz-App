package com.skyrist.offlinequizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.skyrist.offlinequizapp.ui.screen.QuizScreen
import com.skyrist.offlinequizapp.ui.theme.OfflineQuizAppTheme
import androidx.compose.runtime.*
import com.skyrist.offlinequizapp.ui.screen.StartScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var showQuiz by remember { mutableStateOf(false) }

            if (showQuiz) {
                QuizScreen()
            } else {
                StartScreen(
                    onStartClick = { showQuiz = true }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OfflineQuizAppTheme {
        Greeting("Android")
    }
}