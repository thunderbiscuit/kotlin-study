package classes

// if we need to run some code as part of the constructor, we can put that code inside one or more init blocks
// those blocks get executed in order they appear in the class declaration, only once when the object is initialized
class User constructor(val age: Int) {
    val isAdult: Boolean

    init {
        isAdult = age > 18
        println("User is an adult")
    }
}



fun main() {
    val jess = User(age = 20)
    println(jess.isAdult)
}
