fun main() {
    val number: Int = (0..100).random()
    var times = 0

    while (true) {
        if (++times > 5) {
            println("You lost. It was: $number")
        }

        println("Guess a number in 0.100 range: ")
        val answer = readln().toInt()
        if(answer < number) {
            println("Too small.")
        } else if (answer > number) {
            println("Too big.")
        } else {
            println("Bingo!")
            break
        }
    }

    println("Thank for playing!")
}