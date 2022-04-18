package com.getman.cocktailgametest.model

class Score(highest: Int = 0) {
    var currentScore = 0
        private set

    var highestScore = highest
        private set

    fun increment() {
        currentScore++
        if (currentScore > highestScore) {
            highestScore = currentScore
        }
    }
}