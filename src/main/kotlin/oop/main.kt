package oop

fun main() {
    val printer = BasePrinter()
    val secret = BaseSecret(0..100)
    BaseFarewell(
        BaseAttempts(
            BaseVerboseDiff(
                BaseDiff(
                    BaseGuess(),
                    secret
                ),
                printer
            ), 5
        ),
        secret, printer
    ).run()
}