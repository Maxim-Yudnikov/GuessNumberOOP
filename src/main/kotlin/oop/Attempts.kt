package oop

interface Attempts {
    fun iteration(): AttemptState
}

class BaseAttempts(private val verboseDiff: VerboseDiff, private val maxAttempts: Int) : Attempts {
    private var currentAttempt = 0

    init {
        if (maxAttempts < 1)
            throw IllegalArgumentException()
    }

    override fun iteration(): AttemptState {
        val result = verboseDiff.getResultAndWrite()

        return if (++currentAttempt > maxAttempts) AttemptState.Limited else result.mapToAttemptState()
    }
}