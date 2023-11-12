package oop

interface Farewell {
    fun run()
}

class BaseFarewell(private val attempts: Attempts, private val secret: Secret, private val printer: Printer) :
    Farewell {
    override fun run() {
        printer.print("Guess a number in 0.100 range: ")

        while (true) {
            val result = attempts.iteration()
            if (result == AttemptState.Limited) {
                printer.print("You lost. It was: ${secret.getNumber()}")
                break
            } else if (result == AttemptState.Guessed) {
                break
            }
        }
        printer.print("Thank you for playing!")
    }
}