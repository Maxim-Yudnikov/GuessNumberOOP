package oop

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BaseVerboseDiffTest {
    private lateinit var verboseDiff: VerboseDiff
    private lateinit var printer: FakePrinter
    private lateinit var diff: FakeDiff

    @Before
    fun init() {
        diff = FakeDiff()
        printer = FakePrinter()
        verboseDiff = BaseVerboseDiff(diff, printer)
    }

    @Test
    fun test() {
        verboseDiff.getResultAndWrite()
        diff.returnItem = DiffResult.ToSmall
        verboseDiff.getResultAndWrite()
        diff.returnItem = DiffResult.ToBig
        verboseDiff.getResultAndWrite()

        val expected = listOf("Bingo!", "To small.", "To big.")
        assertEquals(expected, printer.printedList)
    }

    private class FakeDiff : Diff {
        var returnItem: DiffResult = DiffResult.Guessed
        override fun getDiff() = returnItem
    }
}