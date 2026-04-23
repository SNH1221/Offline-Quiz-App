package com.skyrist.offlinequizapp.ui.screen

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.skyrist.offlinequizapp.ui.viewmodel.QuizViewModel
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.navigationBarsPadding

@Composable
fun QuizScreen(viewModel: QuizViewModel = viewModel()) {

    val question = viewModel.questions.getOrNull(viewModel.currentIndex)

    if (question == null) return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .statusBarsPadding()
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column {

            // 🔥 HEADER
            Text(
                text = "Grammar Quiz 🧠",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 10.dp)
            )

            Text(
                text = "Question ${viewModel.currentIndex + 1}/5",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(10.dp))

            // 🔥 PROGRESS BAR
            LinearProgressIndicator(
                progress = (viewModel.currentIndex + 1).toFloat() / viewModel.questions.size,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 🔥 QUESTION CARD
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Text(
                    text = question.question,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 🔥 OPTIONS
            question.options.forEachIndexed { index, option ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .clickable {
                            viewModel.selectedOption = index
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = if (viewModel.selectedOption == index)
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
                        else MaterialTheme.colorScheme.surface
                    )
                ) {
                    Text(
                        text = option,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

        // 🔥 NEXT BUTTON
        Button(
            onClick = { viewModel.nextQuestion() },
            enabled = viewModel.selectedOption != -1,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Next ➡️")
        }
    }

    // 🔥 RESULT DIALOG
    if (viewModel.showResult) {

        val context = LocalContext.current

        AlertDialog(
            onDismissRequest = {},
            title = { Text("Results 🎉") },
            text = { Text("Your Score: ${viewModel.score}/5") },

            confirmButton = {
                Button(onClick = { viewModel.resetQuiz() }) {
                    Text("Restart 🔄")
                }
            },

            dismissButton = {
                Button(
                    onClick = {
                        (context as Activity).finish()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Text("Exit ❌")
                }
            }
        )
    }
}