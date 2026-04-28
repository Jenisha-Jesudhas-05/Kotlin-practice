data class Contact(
    val name: String,
    val phone: String
)

fun main() {
    val contacts = mutableListOf<Contact>()

    while (true) {
        println("\n===== Contact Manager =====")
        println("1. Add Contact")
        println("2. View Contacts")
        println("3. Search Contact")
        println("4. Delete Contact")
        println("5. Exit")

        print("Choose an option: ")
        when (readln().toInt()) {
            1 -> {
                print("Enter name: ")
                val name = readln()

                print("Enter phone number: ")
                val phone = readln()

                contacts.add(Contact(name, phone))
                println("Contact added successfully.")
            }

            2 -> {
                if (contacts.isEmpty()) {
                    println("No contacts found.")
                } else {
                    println("\nSaved Contacts:")
                    contacts.forEachIndexed { index, contact ->
                        println("${index + 1}. ${contact.name} - ${contact.phone}")
                    }
                }
            }

            3 -> {
                print("Enter name to search: ")
                val searchName = readln()

                val found = contacts.find {
                    it.name.equals(searchName, ignoreCase = true)
                }

                if (found != null) {
                    println("Contact Found: ${found.name} - ${found.phone}")
                } else {
                    println("Contact not found.")
                }
            }

            4 -> {
                print("Enter name to delete: ")
                val deleteName = readln()

                val removed = contacts.removeIf {
                    it.name.equals(deleteName, ignoreCase = true)
                }

                if (removed) {
                    println("Contact deleted successfully.")
                } else {
                    println("Contact not found.")
                }
            }

            5 -> {
                println("Exiting Contact Manager. Goodbye!")
                break
            }

            else -> println("Invalid option. Please try again.")
        }
    }
}