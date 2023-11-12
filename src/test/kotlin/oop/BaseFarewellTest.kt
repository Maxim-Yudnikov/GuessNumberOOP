package oop

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BaseFarewellTest {
    private lateinit var attempts: FakeAttempts
    private lateinit var secret: FakeSecret
    private lateinit var printer: FakePrinter
    private lateinit var farewell: BaseFarewell

    @Before
    fun init() {
        attempts = FakeAttempts()
        secret = FakeSecret()
        printer = FakePrinter()
        farewell = BaseFarewell(attempts, secret, printer)
    }

    @Test
    fun test_guessed() {
        farewell.run()
        val expected = listOf("Guess a number in 0.100 range: ", "Thank you for playing!")
        val actual = printer.printedList
        assertEquals(expected, actual)
        assertEquals(1, attempts.iterationCounter)
    }

    @Test
    fun test_limited() {
        attempts.returnValue = AttemptState.Limited
        farewell.run()
        val expected = listOf(
            "Guess a number in 0.100 range: ",
            "You lost. It was: 0",
            "Thank you for playing!"
        )
        val actual = printer.printedList
        assertEquals(expected, actual)
    }

    @Test
    fun test_not_guessed() {
        attempts.returnValue = AttemptState.NotGuessed
        attempts.returnGuessedAfter = 1
        farewell.run()
        val expected = listOf(
            "Guess a number in 0.100 range: ",
            "Thank you for playing!"
        )
        val actual = printer.printedList
        assertEquals(expected, actual)
        assertEquals(2, attempts.iterationCounter)
    }

    private class FakeAttempts : Attempts {
        var returnValue: AttemptState = AttemptState.Guessed
        var returnGuessedAfter = Int.MAX_VALUE
        var iterationCounter = 0
        override fun iteration(): AttemptState {
            iterationCounter++
            if(iterationCounter > returnGuessedAfter)
                return AttemptState.Guessed
            return returnValue
        }
    }

    private class FakePrinter : Printer {
        val printedList = mutableListOf<String>()
        override fun print(text: String) {
            printedList.add(text)
        }
    }

    private class FakeSecret : Secret {
        override fun getNumber(): Int {
            return 0
        }
    }
}