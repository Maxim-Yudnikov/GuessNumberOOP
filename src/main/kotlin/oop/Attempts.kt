package oop

interface Attempts {
    fun interation(): AttemptState
}

class BaseAttempts(private val verboseDiff: VerboseDiff, private val maxAttempts: Int) : Attempts {
    private var currentAttempt = 0
    override fun interation(): AttemptState {
        val result = verboseDiff.getResultAndWrite()
        currentAttempt++

        return if (currentAttempt >= maxAttempts) AttemptState.Limited else result.mapToAttemptState()
    }
}