package oop

interface Secret {
    fun getNumber(): Int
}

class BaseSecret(range: IntRange): Secret {
    private val number = range.random()
    override fun getNumber() = number
}