package com.getman.cocktailgametest.model

class Game(questionsList: List<Question>? = null, highest: Int = 0) {

    var currentScore = 0
        private set

    var highestScore = highest
        private set

    private val questions = questionsList?.toMutableList()

    fun incrementScore() {
        currentScore++
        if (currentScore > highestScore) {
            highestScore = currentScore
        }
    }

    fun nextQuestion(): Question? {
        return questions?.removeFirstOrNull()
    }

    fun answer(question: Question, option: String) {
        question.answer(option)
    }
}