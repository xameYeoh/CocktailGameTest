package com.getman.cocktailgametest.model

class Game(highest: Int = 0) {
    var currentScore = 0
        private set

    var highestScore = highest
        private set

    fun incrementScore() {
        currentScore++
        if (currentScore > highestScore) {
            highestScore = currentScore
        }
    }
}