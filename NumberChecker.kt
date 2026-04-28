fun main() {
    print("Enter a number: ")
    val number = readln().toInt()

    when {
        number > 0 -> println("Positive Number")
        number < 0 -> println("Negative Number")
        else -> println("Zero")
    }

    if (number % 2 == 0) {
        println("Even Number")
    } else {
        println("Odd Number")
    }
}