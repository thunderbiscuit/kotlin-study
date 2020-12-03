package exceptions

import kotlin.Exception

// Exception classes are all descendants of the Throwable class

// We throw exceptions using the throw syntax
// throw Exception("Message about the exception")

// an exception thrown at runtime will crash our application
// to prevent this, we can account for that possibility and "catch" exceptions when they are thrown, and tell our program how to handle them

fun divide(x: Int, y: Int): Int {
    try {
        return x / y
    } catch(e: Throwable) {
        kotlin.io.println("You cannot divide by 0, default value returned of 0")
        return 0
    }
}

// We can add as many catch blocks as we want, allowing for example to handle specific exceptions in different ways
// with the last catch statement "catching all" exceptions by using catch(e: Throwable)

// We can use the finally block to run some code no matter what happens to the exception handling control flow

fun divideAndScream(x: Int, y: Int): Int {
    try {
        return x / y
    } catch(e: Throwable) {
        kotlin.io.println("You cannot divide by 0, default value returned of 0")
        return 0
    } finally {
        println("YOU JUST DIVIDED A NUMBER!")
    }
}

// We can define our own exception classes by extending any of the Throwable classes
// It is most common to extend the Exception class
class AgeCannotBeNegative : Exception("Age cannot be negative")
fun verifyAge(age: Int): Unit {
    if (age < 0) {
        throw AgeCannotBeNegative()
    } else {
        println("You're so old!")
    }
}

fun main() {
    println(divide(4, 2))
    println(divide(10, 0))
    println(divideAndScream(4, 2))
    println(divideAndScream(10, 0))

    verifyAge(100)
    verifyAge(-1)
}
