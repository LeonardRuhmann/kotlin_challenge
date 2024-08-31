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
}

val library = mutableListOf<Book>()


fun addBook(book: Book) {
    library.add(book)
}

fun consultBook(bookName: String): List<Book> {
    return library.filter { it.bookName.equals(bookName, ignoreCase = true) }
}

fun consultGender(gender: String): List<Book> {
    return library.filter { it.gender.equals(gender, ignoreCase = true) }
}

fun consultAuthor(author: String): List<Book> {
    return library.filter { it.author.equals(author, ignoreCase = true) }
}

fun updatePagesRead(bookName: String, updatedPagesRead: Int) {
    val book = library.find { it.bookName.equals(bookName, ignoreCase = true) }
    book?.let {
        it.pagesRead += updatedPagesRead
        if (it.pagesRead > it.totalPages) {
            it.pagesRead = it.totalPages
        }
    }
}


fun main() {
    while (true) {
        println("\nMenu:")
        println("0. Add Book")
        println("1. Consult Book")
        println("2. Consult Gender")
        println("3. Consult Author")
        println("4. Update Pages Read")
        println("5. See Reading Progression")
        println("6. Exit")
        print("Choose one option:")


        when (readLine()?.toInt()) {
            0 -> {
                print("Book name: ")
                val bookName = readln()
                print("Gender: ")
                val gender = readln()
                print("Author: ")
                val author = readln()
                print("Total Pages: ")
                val totalPages: Int = readln().toInt()

                val book = Book(bookName, gender, author, totalPages)
                addBook(book)
                println("The book was added successfully")
            }

            1 -> {
                print("Book name: ")
                val bookName: String = readln()
                val books = consultBook(bookName)
                books.forEach { println(it) }
            }

            2 -> {
                print("Gender: ")
                val gender = readln()
                val books = consultGender(gender)
                books.forEach { println(it) }
            }

            3 -> {
                print("Author: ")
                val author = readln()
                val books = consultAuthor(author)
                books.forEach { println(it) }
            }

            4 -> {
                print("Book name: ")
                val bookName = readln()
                print("Pages Read: ")
                val pagesRead = readln().toInt()
                updatePagesRead(bookName, pagesRead)
                print("Pages updated")
            }

            5 -> {
                print("Book name: ")
                val bookName = readln()
                val book = library.find { it.bookName.equals(bookName, ignoreCase = true) }
                book?.let {
                    val progress = it.readingProgression()
                    println("Reading Progress: $progress%")
                } ?: println("Book not found!")
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
