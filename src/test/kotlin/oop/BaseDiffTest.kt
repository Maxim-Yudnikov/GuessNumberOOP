package oop

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BaseDiffTest {
    private lateinit var secret: FakeSecret
    private lateinit var guess: FakeGuess
    private lateinit var diff: BaseDiff

    @Before
    fun init() {
        secret = FakeSecret()
        guess = FakeGuess()
        diff = BaseDiff(guess, secret)
    }

    @Test
    fun test() {
        secret.returnValue = 50
        guess.returnValue = 30
        var actual = diff.getDiff()
        assertEquals(DiffResult.ToSmall, actual)
        guess.returnValue = 80
        actual = diff.getDiff()
        assertEquals(DiffResult.ToBig, actual)
        guess.returnValue = 50
        actual = diff.getDiff()
        assertEquals(DiffResult.Guessed, actual)
    }


    private class FakeSecret: Secret {
        var returnValue = 0
        override fun getNumber() = returnValue
    }
    private class FakeGuess: Guess {
        var returnValue = 0
        override fun readNumber() = returnValue
    }
}