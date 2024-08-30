fun calculateReadingPercetage(bookName: String, totalPages: Int, pagesRead: Int): Any {

    if (bookName != "" && totalPages > 0 && pagesRead >= 0) {
        if(totalPages < pagesRead){
            return println("You can't read more pages than the total")
        }
        val percetage = (pagesRead.toDouble() / totalPages * 100).toInt()
        return println("You read $percetage% of $bookName")
    } else {
        return println("Please check the book information")
    }
}

fun main() {
    println("What's the name of your book?")
    val bookName = readln()
    println("How many pages?")
    val totalPages = readln().toInt()
    println("Pages read?")
    val pagesRead = readln().toInt()
    calculateReadingPercetage(bookName, totalPages, pagesRead);

}