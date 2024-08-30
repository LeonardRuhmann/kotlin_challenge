fun calculateReadingPercentage(bookName: String, totalPages: Int, pagesRead: Int): String {
    if (bookName.isEmpty()) {
        return "Please provide a valid book name."
    }
    if (totalPages <= 0) {
        return "Total pages must be greater than zero."
    }
    if (pagesRead < 0) {
        return "Pages read cannot be negative."
    }
    if (pagesRead > totalPages) {
        return "You can't read more pages than the total."
    }
    val percentage = (pagesRead.toDouble() / totalPages * 100).toInt()
    return "You have read $percentage% of $bookName."
}

fun main() {
    println("What's the name of your book?")
    val bookName = readln()
    println("How many pages?")
    val totalPages = readln().toInt()
    println("Pages read?")
    val pagesRead = readln().toInt()

    val result = calculateReadingPercentage(bookName, totalPages, pagesRead)
    println(result)
}
