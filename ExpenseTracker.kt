data class Expense(
    val title: String,
    val amount: Double,
    val category: String
)

fun main() {
    val expenses = mutableListOf<Expense>()

    while (true) {
        println("\n===== Expense Tracker =====")
        println("1. Add Expense")
        println("2. View Expenses")
        println("3. View Total Expense")
        println("4. Filter by Category")
        println("5. Exit")

        print("Choose an option: ")
        when (readln().toInt()) {
            1 -> {
                print("Enter expense title: ")
                val title = readln()

                print("Enter amount: ₹")
                val amount = readln().toDouble()

                print("Enter category: ")
                val category = readln()

                expenses.add(Expense(title, amount, category))
                println("Expense added successfully.")
            }

            2 -> {
                if (expenses.isEmpty()) {
                    println("No expenses recorded.")
                } else {
                    println("\nExpense List:")
                    expenses.forEachIndexed { index, expense ->
                        println(
                            "${index + 1}. ${expense.title} - ₹${expense.amount} (${expense.category})"
                        )
                    }
                }
            }

            3 -> {
                val total = expenses.sumOf { it.amount }
                println("Total Expense: ₹$total")
            }

            4 -> {
                print("Enter category to filter: ")
                val category = readln()

                val filteredExpenses = expenses.filter {
                    it.category.equals(category, ignoreCase = true)
                }

                if (filteredExpenses.isEmpty()) {
                    println("No expenses found in this category.")
                } else {
                    println("\nExpenses in $category:")
                    filteredExpenses.forEach {
                        println("${it.title} - ₹${it.amount}")
                    }
                }
            }

            5 -> {
                println("Exiting Expense Tracker. Goodbye!")
                break
            }

            else -> println("Invalid option. Please try again.")
        }
    }
}