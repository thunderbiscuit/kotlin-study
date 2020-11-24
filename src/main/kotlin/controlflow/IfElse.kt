package controlflow

val ID1: Boolean = true
val ID2: Boolean = false

// if else control flow
fun checkID(validID: Boolean): Unit {
    if (validID == true) {
        println("The user has a valid ID")
    } else {
        println("The user does not have a valid ID")
    }
}



// if each block of the if-else is simply a return, the whole thing can be written like so
fun checkOtherID(otherValidID: Boolean): String = if (otherValidID == true) "yes" else "no"



// we can simplify boolean condition checks like this
fun checkOtherOtherID(otherOtherValidID: Boolean): String = if (otherOtherValidID) "yes" else "no"



// if else are expressions, and can be used to set variable values
val a: Int = 1
val b: Int = 2
val maxValue = if (a > b) a else b



fun main() {
    checkID(ID1)
    println(checkOtherID(ID2))
    println(maxValue)
}
