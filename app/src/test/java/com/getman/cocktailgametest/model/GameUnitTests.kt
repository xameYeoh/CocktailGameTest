package com.getman.cocktailgametest.model

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.kotlin.*
import java.util.*

class GameUnitTests {
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

    @Test
    fun whenAnsweringCorrectly_shouldIncrementCurrentScore() {
        // Given
        val question = mock<Question>()
        whenever(question.answer(anyString())).thenReturn(true)
        val game = Game(listOf(question))
        // When
        game.answer(question, "OPTION")

        // Then
        assertEquals(1, game.currentScore)
    }

    @Test
    fun whenAnsweringIncorrectly_shouldNotIncrementScore() {
        // Given
        val question = mock<Question>()
        whenever(question.answer(anyString())).thenReturn(false)
        val game = Game(listOf(question))

        // When
        game.answer(question, "OPTION")

        // Then
        assertEquals(0, game.currentScore)
    }
}