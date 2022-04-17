package com.getman.cocktailgametest.model

import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.eq
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import java.util.*

class GameUnitTests {
    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore() {
        val game = Game()

        game.incrementScore()

        Assert.assertEquals("Current score should have been 1", 1, game.currentScore)
    }

    @Test
    fun whenIncrementingScore_aboveHighScore_shouldAlsoIncrementHighScore() {
        val game = Game()

        game.incrementScore()

        Assert.assertEquals(1, game.highestScore)
    }

    @Test
    fun whenIncrementingScore_belowHighScore_shouldNotIncrementHighScore() {
        val game = Game(highest = 10)

        game.incrementScore()

        Assert.assertEquals(10, game.highestScore)
    }

    @Test
    fun whenGettingNextQuestion_shouldReturnFirstFromList() {
        val questions = LinkedList<Question>()
        questions.addAll(listOf(
            Question("Correct1", "Incorrect1"),
            Question("Correct2", "Incorrect2"),
            Question("Correct3", "Incorrect3"),
            Question("Correct4", "Incorrect4"),
        ))

        val firstQuestion = questions.first
        val game = Game(questions)

        val question = game.nextQuestion()

        Assert.assertEquals(firstQuestion, question)
    }

    @Test
    fun whenGettingNextQuestion_withoutMoreQuestions_shouldReturnNull() {
        val questions = LinkedList<Question>()
        questions.add(Question("Correct", "Incorrect"))

        val game = Game(questions)

        game.nextQuestion()
        val question = game.nextQuestion()

        Assert.assertNull(question)
    }

    @Test
    fun whenAnswering_shouldDelegateToQuestion() {
        val question = mock<Question>()
        val game = Game(listOf(question))

        game.answer(question, "OPTION")

        verify(question).answer(eq("OPTION"))
    }
}