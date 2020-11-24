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



fun main() {
    checkID(ID1)
    println(checkOtherID(ID2))
}
