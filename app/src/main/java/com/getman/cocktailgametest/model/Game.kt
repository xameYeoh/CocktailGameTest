package com.getman.cocktailgametest.model

class Game(highest: Int = 0, questionsList: MutableList<Question>? = null) {
    var currentScore = 0
        private set

    var highestScore = highest
        private set

    private val questions = questionsList

    fun incrementScore() {
        currentScore++
        if (currentScore > highestScore) {
            highestScore = currentScore
        }
    }

    fun nextQuestion(): Question? {
        return questions?.removeFirstOrNull()
    }
}