data class Book(
    val title: String,
    val author: String,
    var isAvailable: Boolean = true
)

fun main() {
    val books = mutableListOf(
        Book("The Alchemist", "Paulo Coelho"),
        Book("Atomic Habits", "James Clear"),
        Book("Rich Dad Poor Dad", "Robert Kiyosaki")
    )

    while (true) {
        println("\n===== Library Management System =====")
        println("1. View Books")
        println("2. Borrow Book")
        println("3. Return Book")
        println("4. Add Book")
        println("5. Exit")

        print("Choose an option: ")
        when (readln().toInt()) {
            1 -> {
                println("\nAvailable Books:")
                books.forEachIndexed { index, book ->
                    val status = if (book.isAvailable) "Available" else "Borrowed"
                    println("${index + 1}. ${book.title} by ${book.author} - $status")
                }
            }

            2 -> {
                print("Enter book title to borrow: ")
                val title = readln()

                val book = books.find {
                    it.title.equals(title, ignoreCase = true)
                }

                when {
                    book == null -> println("Book not found.")
                    !book.isAvailable -> println("Book is already borrowed.")
                    else -> {
                        book.isAvailable = false
                        println("You borrowed '${book.title}'.")
                    }
                }
            }

            3 -> {
                print("Enter book title to return: ")
                val title = readln()

                val book = books.find {
                    it.title.equals(title, ignoreCase = true)
                }

                when {
                    book == null -> println("Book not found.")
                    book.isAvailable -> println("This book was not borrowed.")
                    else -> {
                        book.isAvailable = true
                        println("You returned '${book.title}'.")
                    }
                }
            }

            4 -> {
                print("Enter book title: ")
                val title = readln()

                print("Enter author name: ")
                val author = readln()

                books.add(Book(title, author))
                println("Book added successfully.")
            }

            5 -> {
                println("Thank you for using the Library Management System!")
                break
            }

            else -> println("Invalid option. Please try again.")
        }
    }
}