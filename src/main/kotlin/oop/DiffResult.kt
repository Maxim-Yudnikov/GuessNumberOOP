package oop

interface DiffResult {
    fun getMessage(): String
    fun mapToAttemptState(): AttemptState
    object Guessed: DiffResult {
        override fun getMessage() = "Bingo!"
        override fun mapToAttemptState() = AttemptState.Guessed
    }

    interface Failed: DiffResult
    abstract class Abstract: Failed {
        override fun mapToAttemptState() = AttemptState.NotGuessed
    }
    object ToSmall: Abstract() {
        override fun getMessage() = "To small."
    }

    object ToBig: Abstract() {
        override fun getMessage() = "To big."
        override fun mapToAttemptState() = AttemptState.NotGuessed
    }
}