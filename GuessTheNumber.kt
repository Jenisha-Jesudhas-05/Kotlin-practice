import kotlin.random.Random

fun main() {
    val secretNumber = Random.nextInt(1, 101)
    var attempts = 0

    println("Welcome to Guess the Number Game!")
    println("I'm thinking of a number between 1 and 100.")

    while (true) {
        print("Enter your guess: ")
        val guess = readln().toInt()
        attempts++

        when {
            guess < secretNumber -> println("Too low! Try again.")
            guess > secretNumber -> println("Too high! Try again.")
            else -> {
                println("Congratulations! You guessed the number.")
                println("Total attempts: $attempts")
                break
            }
        }
    }
}