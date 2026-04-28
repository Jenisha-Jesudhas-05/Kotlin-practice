data class Question(
    val question: String,
    val options: List<String>,
    val correctAnswer: Int
)

fun main() {
    val questions = listOf(
        Question(
            "What is the capital of India?",
            listOf("Mumbai", "Delhi", "Chennai", "Kolkata"),
            2
        ),
        Question(
            "Which language is used for Android Development?",
            listOf("Python", "Java", "Kotlin", "Swift"),
            3
        ),
        Question(
            "Who developed Kotlin?",
            listOf("Google", "Microsoft", "JetBrains", "Oracle"),
            3
        )
    )

    var score = 0

    println("===== Welcome to Kotlin Quiz =====")

    questions.forEachIndexed { index, question ->
        println("\nQuestion ${index + 1}: ${question.question}")

        question.options.forEachIndexed { optionIndex, option ->
            println("${optionIndex + 1}. $option")
        }

        print("Enter your answer (1-4): ")
        val userAnswer = readln().toInt()

        if (userAnswer == question.correctAnswer) {
            println("Correct!")
            score++
        } else {
            println(
                "Wrong! Correct answer: ${
                    question.options[question.correctAnswer - 1]
                }"
            )
        }
    }

    println("\n===== Quiz Completed =====")
    println("Your Score: $score/${questions.size}")

    val percentage = (score.toDouble() / questions.size) * 100

    println("Percentage: $percentage%")

    when {
        percentage == 100.0 -> println("Excellent!")
        percentage >= 70 -> println("Great Job!")
        percentage >= 50 -> println("Good Effort!")
        else -> println("Keep Practicing!")
    }
}