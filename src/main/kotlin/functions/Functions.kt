package functions



// functions are declared using the fun keyword
// function signatures include the type returned
// the Unit type is the equivalent of "nothing"
fun sayHello(): Unit {
    println("Hello!")
}

fun isBitcoinAlive(): Boolean {
    return true
}



// functions take parameters
// we call these functions using the order of the parameters
fun greetings(name: String): Unit {
    println("Greetings, $name!")
}

fun plus2(number: Int): Int {
    return number + 2
}



// we can build functions using named arguments
// which allows us to provide the arguments to the function call in any order
// we can use a mix of named arguments and positioned arguments as long as all the positioned arguments
// are placed before the named arguments or that all named arguments are in the order of the positioned arguments
fun addNumbers(num1: Int, num2: Int): Int {
    val total: Int = num1 + num2
    return total
}

fun addLotsOfNumbers(
        num1: Int,
        num2: Int,
        num3: Int,
        num4: Int,
): Int {
    return num1 + num2 + num3 + num4
}
// addLotsOfNumbers(1, 2, num3 = 7, num4 = 8)
// addLotsOfNumbers(num1 = 1, 2, 4, num4 = 8)
// addLotsOfNumbers(num1 = 1, num4 = 2, 4, 4) // throws error: Mixing named and positioned arguments is not allowed



// we can give default values to parameters
fun multiplyNumbers(num1: Int, num2: Int = 1): Int {
    val total: Int = num1 * num2
    return total
}



// we should use trailing comas when declaring function parameters
fun example(num1: Int, num2: Int, num3: Int,): Unit {
    println("I'm an example")
}



// if a function has only one line and it's a return statement
// we can shorten the function declaration
fun addThree(number: Int): Int = number + 3



fun main() {
    sayHello()
    isBitcoinAlive()

    greetings("Anderson")
    plus2(1)

    addNumbers(num2 = 1, num1 = 9)

    println(multiplyNumbers(6, 4))
    println(multiplyNumbers(12))

    addLotsOfNumbers(1, 2, num3 = 7, num4 = 8)
    addLotsOfNumbers(1, num2 = 2, 7, num4 = 8)
    // addLotsOfNumbers(num1 = 1, num4 = 2, 4, 4) // throws error

    println(addThree(1))
}
// TODO: varargs parameters
