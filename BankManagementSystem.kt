data class BankAccount(
    val accountNumber: Int,
    val accountHolder: String,
    var balance: Double
)

fun main() {
    val accounts = mutableListOf<BankAccount>()

    while (true) {
        println("\n===== Bank Management System =====")
        println("1. Create Account")
        println("2. View Accounts")
        println("3. Deposit Money")
        println("4. Withdraw Money")
        println("5. Search Account")
        println("6. Exit")

        print("Choose an option: ")
        when (readln().toInt()) {
            1 -> {
                print("Enter Account Number: ")
                val accountNumber = readln().toInt()

                if (accounts.any { it.accountNumber == accountNumber }) {
                    println("Account number already exists.")
                    continue
                }

                print("Enter Account Holder Name: ")
                val accountHolder = readln()

                print("Enter Initial Deposit: ₹")
                val balance = readln().toDouble()

                accounts.add(
                    BankAccount(
                        accountNumber,
                        accountHolder,
                        balance
                    )
                )

                println("Account created successfully.")
            }

            2 -> {
                if (accounts.isEmpty()) {
                    println("No accounts found.")
                } else {
                    println("\nAll Bank Accounts:")
                    accounts.forEach {
                        println(
                            "Account No: ${it.accountNumber}, " +
                            "Name: ${it.accountHolder}, " +
                            "Balance: ₹${it.balance}"
                        )
                    }
                }
            }

            3 -> {
                print("Enter Account Number: ")
                val accountNumber = readln().toInt()

                val account = accounts.find {
                    it.accountNumber == accountNumber
                }

                if (account != null) {
                    print("Enter Deposit Amount: ₹")
                    val amount = readln().toDouble()

                    if (amount > 0) {
                        account.balance += amount
                        println("₹$amount deposited successfully.")
                    } else {
                        println("Invalid amount.")
                    }
                } else {
                    println("Account not found.")
                }
            }

            4 -> {
                print("Enter Account Number: ")
                val accountNumber = readln().toInt()

                val account = accounts.find {
                    it.accountNumber == accountNumber
                }

                if (account != null) {
                    print("Enter Withdrawal Amount: ₹")
                    val amount = readln().toDouble()

                    when {
                        amount <= 0 -> println("Invalid amount.")
                        amount > account.balance ->
                            println("Insufficient balance.")
                        else -> {
                            account.balance -= amount
                            println("₹$amount withdrawn successfully.")
                        }
                    }
                } else {
                    println("Account not found.")
                }
            }

            5 -> {
                print("Enter Account Number: ")
                val accountNumber = readln().toInt()

                val account = accounts.find {
                    it.accountNumber == accountNumber
                }

                if (account != null) {
                    println("\nAccount Details:")
                    println("Account Number: ${account.accountNumber}")
                    println("Account Holder: ${account.accountHolder}")
                    println("Balance: ₹${account.balance}")
                } else {
                    println("Account not found.")
                }
            }

            6 -> {
                println("Thank you for using the Bank Management System!")
                break
            }

            else -> println("Invalid choice. Please try again.")
        }
    }
}