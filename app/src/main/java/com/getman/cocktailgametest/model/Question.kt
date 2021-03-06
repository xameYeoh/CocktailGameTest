package com.getman.cocktailgametest.model

class Question(private val correctOption: String, private val incorrectOption: String) {
    var answeredOption: String? = null
        private set

    val isAnsweredCorrectly: Boolean
        get() = answeredOption == correctOption

    fun answer(option: String): Boolean {
        if (option != correctOption && option != incorrectOption)
            throw IllegalArgumentException("Not a valid option")

        answeredOption = option

        return answeredOption == correctOption
    }

    fun getOptions(shuffle: (MutableList<String>) -> Unit = { it.shuffled() }): List<String> {
        val options = mutableListOf(correctOption, incorrectOption)
        shuffle(options)

        return options
    }
}