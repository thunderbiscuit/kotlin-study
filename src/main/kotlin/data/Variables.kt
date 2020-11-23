package data

// variables are declared as being immutable (val) or mutable (var)
// the variable type is declared after a colon right after the name of the variable

val name: String = "thunderbiscuit"
var age: Int = 30

// variable type can be inferred by the compiler
val country = "Canada"

fun printInfo(name: String, age: Int) {
    println("Name: $name, Age: $age")
}

// variables by default are non-nullable
//you can allow a variable to be null by declaring it like so:
var kids: Boolean? = null
