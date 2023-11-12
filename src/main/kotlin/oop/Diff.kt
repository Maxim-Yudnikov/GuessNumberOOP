package oop

interface Diff {
    fun getDiff(): DiffResult
}

class BaseDiff(private val guess: Guess, private val secret: Secret) : Diff {
    override fun getDiff(): DiffResult {
        val writtenNumber = guess.readNumber()
        val guessedNumber = secret.getNumber()

        return if (writtenNumber > guessedNumber) DiffResult.ToBig
        else if (writtenNumber < guessedNumber) DiffResult.ToSmall
        else DiffResult.Guessed
    }
}