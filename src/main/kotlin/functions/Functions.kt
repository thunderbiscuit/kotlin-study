package functions

// functions are declared using the fun keyword
// function signatures include the type returned
// the Unit type is the equivalent of nothing of value
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
// we can use a mix of named arguments and positioned arguments as long all arguments subsequent to the first
// named argument also be named
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
// we can shorten the function declaration like so
fun addThree(number: Int): Int = number + 3



// we can pass a variable number of arguments to a function using a vararg parameter
// the arguments passed to the vararg parameter must all be of the same type
// you can use the spread operator to pass an array as arguments to a function that uses a vararg parameter
// it is not necessary for the vararg parameter to be the last parameter
// if it is not, however, all other arguments must be passed using named arguments
val interestingThings: Array<String> = arrayOf("Android", "Kotlin", "Bitcoin")
fun nameInterestingThings(vararg interestingThings: String): Unit {
    for (i in interestingThings) {
        println("$i is interesting")
    }
}
// nameInterestingThings("Android", "Kotlin", "Bitcoin",)
// nameInterestingThings(*interestingThings)


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

    nameInterestingThings("a", "b", "c",)
    nameInterestingThings(*interestingThings)



    //we can use methods known as toString methods.
    //this toString demonstrates it with numbers
    //The toString method is used to return a string representation of an object.
    
    //using a toString(), we can print out a number (int)
    val number = 15
    println(number.toString())

    //this toString also works with strings
    val string = "Hello Kotlin"
    println(string.toString())

    //toStrings can also work with objects
    //see below for class
    val student = Student("ThunderBiscuit", 123456)
    println(student.toString())


}



//data class for toString method demonstration
data class Student(val name:String, var studentId:Int)
