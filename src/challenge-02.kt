data class Book(
    val bookName: String,
    val gender: String,
    val author: String,
    val totalPages: Int,
    var pagesRead: Int = 0
) {

    fun readingProgression(): Int {
        return ((pagesRead.toDouble() / totalPages) * 100).toInt()
    }

    fun updatePagesRead(pages: Int) {
        if (pages < 0) {
            println("Invalid page count. It must be a positive number.")
            return
        }
        pagesRead += pages
        if (pagesRead > totalPages) {
            pagesRead = totalPages
        }
    }
}

val library = mutableListOf<Book>()


fun addBook(book: Book) {
    library.add(book)
}

fun findBookByName(bookName: String): List<Book> {
    return library.filter { it.bookName.equals(bookName, ignoreCase = true) }
}

fun findBookByGender(gender: String): List<Book> {
    return library.filter { it.gender.equals(gender, ignoreCase = true) }
}

fun findBookByAuthor(author: String): List<Book> {
    return library.filter { it.author.equals(author, ignoreCase = true) }
}

fun updatePagesRead(bookName: String, updatedPagesRead: Int) {
    val book = library.find { it.bookName.equals(bookName, ignoreCase = true) }
    if (book != null) {
        book.updatePagesRead(updatedPagesRead)
        println("Pages updated.")
    } else {
        println("Book not found!")
    }
}

fun showMenu() {
    println("\nMenu:")
    println("0. Add Book")
    println("1. Consult Book")
    println("2. Consult Gender")
    println("3. Consult Author")
    println("4. Update Pages Read")
    println("5. See Reading Progression")
    println("6. Exit")

}

fun main() {
    while (true) {
        showMenu()
        print("Choose one option: ")

        val option = readLine()?.toIntOrNull()
        when (option) {
            0 -> {
                print("Book name: ")
                val bookName = readln()
                print("Gender: ")
                val gender = readln()
                print("Author: ")
                val author = readln()
                print("Total Pages: ")
                val totalPages = readln().toIntOrNull()

                if (totalPages != null && totalPages > 0) {
                    val book = Book(bookName, gender, author, totalPages)
                    addBook(book)
                    println("The book was added successfully")
                } else {
                    println("Invalid number of total pages")
                }
            }

            1 -> {
                print("Book name: ")
                val bookName: String = readln()
                val books = findBookByName(bookName)
                if(books.isEmpty()) {
                    println("No books found by that name")
                } else {
                    books.forEach { println(it) }
                }
            }

            2 -> {
                print("Gender: ")
                val gender = readln()
                val books = findBookByGender(gender)
                if (books.isEmpty()) {
                    println("No books found by that gender.")
                } else {
                    books.forEach { println(it) }
                }
            }

            3 -> {
                print("Author: ")
                val author = readln()
                val books = findBookByAuthor((author))
                if (books.isEmpty()) {
                    println("No books found by that author")
                } else {
                    books.forEach { println(it) }
                }
            }

            4 -> {
                print("Book name: ")
                val bookName = readln()
                print("Pages Read: ")
                val pagesRead = readln().toIntOrNull()

                if (pagesRead != null && pagesRead >= 0) {
                    updatePagesRead(bookName, pagesRead)
                } else {
                    println("Invalid page count.")
                }
            }

            5 -> {
                print("Book name: ")
                val bookName = readln()
                val book = library.find { it.bookName.equals(bookName, ignoreCase = true) }
                if (book != null) {
                    val progress = book.readingProgression()
                    println("Reading Progress: $progress%")

                } else {
                    println("Book not found!")
                }
            }

            6 -> {
                println("Exiting...")
                break
            }

            else -> {
                println("Invalid option!")
            }
        }
    }
}
