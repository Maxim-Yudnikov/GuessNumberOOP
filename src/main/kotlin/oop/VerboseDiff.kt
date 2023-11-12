package oop

interface VerboseDiff {
    fun getResultAndWrite(): DiffResult
}

class BaseVerboseDiff(private val diff: Diff, private val printer: Printer) : VerboseDiff {
    override fun getResultAndWrite(): DiffResult {
        val result = diff.getDiff()
        printer.print(result.getMessage())
        return result
    }
}