package oop

interface Printer {
    fun print(text: String)
}

class BasePrinter: Printer {
    override fun print(text: String) {
        println(text)
    }
}