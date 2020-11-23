package functions

// functions are declared using the fun keyword
// function signatures include the type returned
// the Unit type is the equivalent of "nothing"

fun greetings(name: String): Unit {
    println("Greetings, $name!")
}
fun plus2(number: Int): Int {
    return number + 2
}

fun isBitcoinDead(): Boolean {
    return false
}

fun main() {
    greetings("Anderson")
    plus2(1)
    isBitcoinDead()
}

