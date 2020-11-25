package controlflow

fun main() {

    val number: Int = 2

    // when matches its argument against all branches sequentially until some branch condition is satisfied
    // the else branch is evaluated if none of the other branch conditions are satisfied
    when (number) {
        1 -> println("the number is 1")
        2 -> println("the number is 2")
        else -> println("the number is something else")
    }

    // if many cases should be handled the same way, the branch conditions may be combined with a comma
    when (number) {
        1, 2, 3, 4 -> println("the number is 1, 2, 3, or 4")
        8 -> println("the number is 8")
        else -> println("the number is something else")
    }
}
