package oop

interface Guess {
    fun readNumber(): Int
}

class BaseGuess(): Guess {
    override fun readNumber(): Int {
        return readln().toInt()
    }
}