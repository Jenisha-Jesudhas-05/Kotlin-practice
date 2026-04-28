fun main() {
    print("Enter first number: ")
    val num1 = readln().toDouble()

    print("Enter operator (+, -, *, /): ")
    val operator = readln()

    print("Enter second number: ")
    val num2 = readln().toDouble()

    val result = when (operator) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> {
            if (num2 != 0.0) {
                num1 / num2
            } else {
                println("Division by zero is not allowed.")
                return
            }
        }
        else -> {
            println("Invalid operator.")
            return
        }
    }

    println("Result: $result")
}