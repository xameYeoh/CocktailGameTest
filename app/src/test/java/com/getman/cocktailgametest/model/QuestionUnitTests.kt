package com.getman.cocktailgametest.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.Collections.shuffle

class QuestionUnitTests {
    private lateinit var question: Question

    @Before
    fun setup() {
        question = Question("CORRECT", "INCORRECT")
    }

    @Test
    fun whenCreatingQuestion_shouldNotHaveAnsweredOption() {
        Assert.assertNull(question.answeredOption)
    }

    @Test
    fun whenAnswering_shouldHaveAnsweredOption() {
        question.answer("INCORRECT")

        Assert.assertEquals("INCORRECT", question.answeredOption)
    }

    @Test
    fun whenAnswering_withCorrectOption_shouldReturnTrue() {
        val result = question.answer("CORRECT")

        Assert.assertTrue(result)
    }

    @Test
    fun whenAnswering_withIncorrectOption_shouldReturnFalse() {
        val result = question.answer("INCORRECT")

        Assert.assertFalse(result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun whenAnswering_withInvalidOption_shouldThrowException() {
        question.answer("INVALID")
    }

    @Test
    fun whenGettingOptions_shouldReturnShuffledList() {
        val options = question.getOptions()

        Assert.assertTrue(options is List<String>)
    }

    @Test
    fun whenGettingOptions_shouldContainCorrectAndIncorrectOptions() {
        val options = question.getOptions()
        var countCorrect = 0
        var countIncorrect = 0

        for (option in options) {
            question.answer(option)
            if (question.isAnsweredCorrectly)
                countCorrect++
            else
                countIncorrect++
        }

        Assert.assertTrue(countCorrect > 0)
        Assert.assertTrue(countIncorrect > 0)
    }

    @Test
    fun whenGettingOptions_shouldTakeLambdaForShuffling() {
        question.getOptions {
            it.shuffled()
        }
    }
}