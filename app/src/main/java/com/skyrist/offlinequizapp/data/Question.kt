package com.skyrist.offlinequizapp.data

data class Question(
    val question: String,
    val options: List<String>,
    val correctAnswer: Int
)
