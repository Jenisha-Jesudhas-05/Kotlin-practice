fun main() {
    print("Enter student marks (0-100): ")
    val marks = readln().toInt()

    if (marks < 0 || marks > 100) {
        println("Invalid marks! Please enter marks between 0 and 100.")
        return
    }

    val grade = when {
        marks >= 90 -> "A+"
        marks >= 80 -> "A"
        marks >= 70 -> "B"
        marks >= 60 -> "C"
        marks >= 50 -> "D"
        else -> "Fail"
    }

    println("Student Grade: $grade")
}