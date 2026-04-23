package com.skyrist.offlinequizapp.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import com.skyrist.offlinequizapp.data.Question
import com.skyrist.offlinequizapp.data.QuestionRepository

class QuizViewModel : ViewModel() {

    private val repository = QuestionRepository()

    var questions = mutableStateListOf<Question>()
    var currentIndex by mutableStateOf(0)
    var selectedOption by mutableStateOf(-1)
    var score by mutableStateOf(0)
    var showResult by mutableStateOf(false)

    init {
        loadQuestions()
    }

    private fun loadQuestions() {
        questions.addAll(repository.getQuestions())
    }

    fun nextQuestion() {

        if (selectedOption == questions[currentIndex].correctAnswer) {
            score++
        }

        selectedOption = -1

        if (currentIndex < questions.size - 1) {
            currentIndex++
        } else {
            showResult = true
        }
    }

    fun resetQuiz() {
        currentIndex = 0
        score = 0
        selectedOption = -1
        showResult = false
    }
}