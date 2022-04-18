package com.getman.cocktailgametest.model

class Game(questionsList: List<Question>? = null, highest: Int = 0) {
    private val score = Score(highest)

    val currentScore: Int
        get() = score.currentScore

    val highestScore: Int
        get() = score.highestScore

    private val questions = questionsList?.toMutableList()

    fun nextQuestion(): Question? {
        return questions?.removeFirstOrNull()
    }

    fun answer(question: Question, option: String) {
        val result = question.answer(option)

        if (result) {
            score.increment()
        }
    }
}