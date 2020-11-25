package lambdas


// function types
// all function types have a parenthesized parameter types list and a return type
// () -> Unit

// (Int, String) -> String
// denotes a type that represent functions that take an Int and a String and returns a String

// function types can optionally have an additional receiver type, which is specified before a dot in the notation
// List<Int>.(Int) -> Unit

// the function type notation can optionally include names for the function parameters
// (x: Int, y: Int) -> Student

// because functions are first-class citizens, variables can hold functions as values
// the following are called lambda expressions
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
val printSum: (Int, Int) -> Unit = { x: Int, y: Int -> println(x + y) }



// we can build our own higher-order functions
fun performOperationOn(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    val result: Int = operation(x, y)
    println("Operation performed with returned value $result")
    return result
}


fun main() {

    var list: List<Int> = (1..20).toList()
    println(list)



    // lambdas pass functions as parameters to other functions
    // higher order functions are functions that take other functions as parameters, or return functions themselves
    // take the filter method applied to lists; it requires we pass it a function to know what filter to apply
    val smallList: List<Int> = list.filter({ it < 17 })
    println(smallList)



    // if the lambda passed as a parameter to a function is the last parameter passed (as above)
    // it can be taken out of the parentheses
    val verySmallList: List<Int> = list.filter() { it < 4 }
    println("Very small list: $verySmallList")



    // if there are no arguments inside the parentheses (as above), we can remove the parens
    val evenList: List<Int> = list.filter { (it % 2 == 0) }
    println(evenList)



    // calling the variables that hold functions
    sum(1, 1)
    printSum(1, 6)



    // custom-built higher-order function
    performOperationOn(1, 19, { x: Int , y: Int -> x + y })
    performOperationOn(1, 19, { x, y -> x + y })
    performOperationOn(4, 8) { x, y, -> x * y }

    // using an anonymous function instead of a lambda
    val anonymousFunction = fun(num1: Int, num2: Int): Int = num1 + num2
    performOperationOn(1, 4, anonymousFunction)

    performOperationOn(7, 8, fun(num1: Int, num2: Int) = num1 + num2)
}
