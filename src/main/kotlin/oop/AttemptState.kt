package oop

interface AttemptState {
    object Guessed: AttemptState
    object NotGuessed: AttemptState
    object Limited: AttemptState
}