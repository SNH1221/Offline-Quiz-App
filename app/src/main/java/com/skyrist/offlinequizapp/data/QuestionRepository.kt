package com.skyrist.offlinequizapp.data

class QuestionRepository {

    fun getQuestions(): List<Question> {
        return listOf(
            Question(
                question = "Neither of the boys ___ willing to take responsibility.",
                options = listOf("are", "were", "is", "have"),
                correctAnswer = 2
            ),
            Question(
                question = "Had she studied harder, she ___ the exam.",
                options = listOf("would pass", "would have passed", "will pass", "passed"),
                correctAnswer = 1
            ),
            Question(
                question = "Each of the players ___ given a medal.",
                options = listOf("were", "have", "was", "are"),
                correctAnswer = 2
            ),
            Question(
                question = "No sooner ___ the train left than it started raining.",
                options = listOf("did", "had", "has", "was"),
                correctAnswer = 1
            ),
            Question(
                question = "He behaves as though he ___ everything.",
                options = listOf("knows", "knew", "has known", "know"),
                correctAnswer = 1
            )
        )
    }
}