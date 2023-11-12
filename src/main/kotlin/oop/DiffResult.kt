package oop

interface DiffResult {
    fun getMessage(): String
    fun mapToAttemptState(): AttemptState
    object Guessed: DiffResult {
        override fun getMessage() = "Bingo!"
        override fun mapToAttemptState() = AttemptState.Guessed
    }

    interface Failed: DiffResult
    object ToSmall: Failed {
        override fun getMessage() = "To small."
        override fun mapToAttemptState() = AttemptState.NotGuessed
    }

    object ToBig: Failed {
        override fun getMessage() = "To big."
        override fun mapToAttemptState() = AttemptState.NotGuessed
    }
}