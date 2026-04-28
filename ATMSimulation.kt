fun main() {
    var balance = 1000.0

    while (true) {
        println("\n===== ATM Menu =====")
        println("1. Check Balance")
        println("2. Deposit Money")
        println("3. Withdraw Money")
        println("4. Exit")

        print("Choose an option: ")
        val choice = readln().toInt()

        when (choice) {
            1 -> {
                println("Current Balance: ₹$balance")
            }

            2 -> {
                print("Enter amount to deposit: ₹")
                val amount = readln().toDouble()

                if (amount > 0) {
                    balance += amount
                    println("₹$amount deposited successfully.")
                } else {
                    println("Invalid amount.")
                }
            }

            3 -> {
                print("Enter amount to withdraw: ₹")
                val amount = readln().toDouble()

                when {
                    amount <= 0 -> println("Invalid amount.")
                    amount > balance -> println("Insufficient balance.")
                    else -> {
                        balance -= amount
                        println("₹$amount withdrawn successfully.")
                    }
                }
            }

            4 -> {
                println("Thank you for using our ATM!")
                break
            }

            else -> {
                println("Invalid choice. Please try again.")
            }
        }
    }
}