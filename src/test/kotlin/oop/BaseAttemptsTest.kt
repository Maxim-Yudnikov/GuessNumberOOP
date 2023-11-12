package oop

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BaseAttemptsTest {
    private lateinit var verboseDiff: FakeVerboseDiff

    @Before
    fun init() {
        verboseDiff = FakeVerboseDiff()
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_negative_attempts() {
        val attempts = BaseAttempts(verboseDiff, -1)
    }

    @Test
    fun test_limited() {
        val attempts = BaseAttempts(verboseDiff, 2)
        var actual = attempts.iteration()
        var expected: AttemptState = AttemptState.NotGuessed
        assertEquals(expected, actual)
        actual = attempts.iteration()
        expected = AttemptState.NotGuessed
        assertEquals(expected, actual)
        actual = attempts.iteration()
        expected = AttemptState.Limited
        assertEquals(expected, actual)
    }

    private class FakeVerboseDiff : VerboseDiff {
        override fun getResultAndWrite(): DiffResult {
            return DiffResult.ToSmall
        }
    }
}