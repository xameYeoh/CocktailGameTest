package com.getman.cocktailgametest.model

import org.junit.Assert
import org.junit.Test

class ScoreUnitTests {
    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore() {
        val score = Score()

        score.increment()

        Assert.assertEquals("Current score should have been 1", 1, score.currentScore)
    }

    @Test
    fun whenIncrementingScore_aboveHighScore_shouldAlsoIncrementHighScore() {
        val score = Score()

        score.increment()

        Assert.assertEquals(1, score.highestScore)
    }

    @Test
    fun whenIncrementingScore_belowHighScore_shouldNotIncrementHighScore() {
        val score = Score(highest = 10)

        score.increment()

        Assert.assertEquals(10, score.highestScore)
    }
}