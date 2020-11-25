package classes

// a singleton is an class that can only be instantiated once
// this is done using a syntax called object declaration
object DatabaseManager {
    fun connectToDatabase(databaseID: Int) {
        println("Connected to database")
    }
}



fun main() {
    // the object's initialization is thread-safe and is done at first access (like below)
    DatabaseManager.connectToDatabase(42)
}
