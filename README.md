This website is the 1-pager version of a series of packages, code samples, and short explorations of the Kotlin language I keep in [this repo](https://github.com/thunderbiscuit/kotlin-study).

<br/>

## Data
```kotlin
package data
```  

### Variables 
`src/main/kotlin/data/Variables.kt`

Variables are declared as being read-only (`val`) or mutable (`var`). The variable type is declared after a colon right after the name of the variable.
```kotlin
val name: String = "thunderbiscuit"
var age: Int = 100
```

Variable type can be inferred by the compiler
```kotlin
val country = "North Pole"
```

Variables by default are non-nullable. You can allow a variable to be null by declaring it like so:
```kotlin
var kids: Boolean? = null
```
<br/>

### Destructuring
`/src/main/kotlin/data/Destructuring.kt`

```kotlin
fun main() {

    data class FamousPerson(val nationality: String, val talents: String)
    val Adele: FamousPerson = FamousPerson("British", "Singer")

    // Kotlin has a syntax called destructuring declaration, which creates multiple variables at once
    // data class FamousPerson(val nationality: String, val talents: String)
    val (adeleNationality: String, adeleTalents: String) = Adele

    println(Adele.nationality)
    println(Adele.talents)

    println(adeleNationality)
    println(adeleTalents)

    // a destructuring declaration is compiled down to the following code
    val adeleNationality2: String = Adele.component1()
    val adeleTalents2: String = Adele.component2()


    // a great way to traverse a map is using function declarations
    val months: Map<String, String> = mapOf("January" to "very cold", "February" to "cold", "March" to "not bad", "April" to "warm", "May" to "awesome!")
    for ((month, temperature) in months) {
        println("$month is $temperature")
    }

    // if you don't need a variable, you can place an underscore instead of naming it
    for ((_, temperature) in months) {
        println("$temperature")
    }
}

```
<br/>

### Operator Overloading
`src/main/kotlin/data/OperatorOverloading.kt`

Operators like `+` and `-` can be defined for custom classes.

```kotlin
class BasketOfApples constructor(val apples: Int) {
    
    operator fun plus(otherBasket: BasketOfApples): BasketOfApples {
        return BasketOfApples(apples + otherBasket.apples)
    }
}


fun main() {

    val basket1: BasketOfApples = BasketOfApples(100)
    val basket2: BasketOfApples = BasketOfApples(42)
    println(basket1.apples) // 100
    println(basket2.apples) // 42

    val basket3: BasketOfApples = basket1 + basket2
    println(basket3.apples) // 142
}
```
<br/>
<br/>

## Functions
```kotlin
package functions
```

### Functions
`/src/main/kotlin/functions/Functions.kt`  

Functions are declared using the `fun` keyword. Function signatures include the type returned.

The Unit type is the equivalent of "nothing of value"
```kotlin
fun sayHello(): Unit {
    println("Hello!")
}

fun isBitcoinAlive(): Boolean {
    return true
}
```

Functions take parameters. We call these functions using the order of the parameters.
```kotlin
fun greetings(name: String): Unit {
    println("Greetings, $name!")
}

fun plus2(number: Int): Int {
    return number + 2
}
```

// we can build functions using named arguments
// which allows us to provide the arguments to the function call in any order
// we can use a mix of named arguments and positioned arguments as long all arguments subsequent to the first
// named argument also be named
```kotlin
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
```

We can give default values to parameters.
```kotlin
fun multiplyNumbers(num1: Int, num2: Int = 1): Int {
    val total: Int = num1 * num2
    return total
}
```

We should use trailing comas when declaring function parameters
```kotlin
fun example(num1: Int, num2: Int, num3: Int,): Unit {
    println("I'm an example")
}
```

If a function has only one line and it's a return statement we can shorten the function declaration like so:
```kotlin
fun addThree(number: Int): Int = number + 3
```

We can pass a variable number of arguments to a function using a vararg parameter. The arguments passed to the vararg parameter must all be of the same type. We can use the spread operator to pass an array as arguments to a function that uses a vararg parameter. It is not necessary for the vararg parameter to be the last parameter. If it is not, however, all other arguments must be passed using named arguments.
```kotlin
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
}
```
<br/>

## Imports and Standard Library
```kotlin
package standardlibrary
```

### Imports 
`/src/main/kotlin/Imports.kt`

Each file declares its belonging to a package with the following statement. It is customary to have all files in the same directory belong to the same package but it does not have to be so.

A number of packages are imported into every Kotlin file by default
```kotlin
import kotlin.*
import kotlin.annotation.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*
```

In the case of Kotlin on the JVM, those packages are also imported by default
```kotlin
import java.lang.*
import kotlin.jvm.*
```

We import from the Standard Library using statements like the following
```kotlin
import kotlin.random.Random
```

We can rename symbols in their import statements
```kotlin
import kotlin.ranges.until as untilButNotIncluding

fun main() {
    // Random
    Random.nextInt(from = 0, until = 5)

    // Ranges
    5.untilButNotIncluding(to = 10)
}
```
<br/>
<br/>

## Control Flow
```kotlin
package controlflow
```

### If/Else
`src/main/kotlin/controlflow/IfElse.kt`

```kotlin
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
```
<br/>

### For Loops
`/src/main/kotlin/controlflow/ForLoops.kt`

```kotlin
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
```
