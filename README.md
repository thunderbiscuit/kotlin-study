# Kotlin Study 😎

This website is the 1-pager version of a series of packages, code samples, and short explorations of the Kotlin language I keep in [this repo](https://github.com/thunderbiscuit/kotlin-study).

<button class="btn js-toggle-dark-mode">Preview dark color scheme</button>

<script>
const toggleDarkMode = document.querySelector('.js-toggle-dark-mode');

jtd.addEvent(toggleDarkMode, 'click', function(){
  if (jtd.getTheme() === 'dark') {
    jtd.setTheme('light');
    toggleDarkMode.textContent = 'Preview dark color scheme';
  } else {
    jtd.setTheme('dark');
    toggleDarkMode.textContent = 'Return to the light side';
  }
});
</script>

<br/>
<center>
    <img src="./Kotlin-logo.svg.png" width="200">
</center>
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

Kotlin has a syntax called destructuring declaration, which creates multiple variables at once. 

```kotlin
fun main() {

    data class FamousPerson(val nationality: String, val talents: String)
    val Adele: FamousPerson = FamousPerson("British", "Singer")

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
val cities: List<String> = listOf("Vancouver", "Calgary", "Regina", "Toronto", "Ottawa", "Fredericton")

fun main() {
    for (city: String in cities) {
        println(city)
    }
}
```
<br/>

### When
`src/main/kotlin/controlflow/When.kt`

`when` matches its argument against all branches sequentially until some branch condition is satisfied. The `else` branch is evaluated if none of the other branch conditions are satisfied.
```kotlin
val number: Int = 2

when (number) {
    1 -> println("the number is 1")
    2 -> println("the number is 2")
    else -> println("the number is something else")
}
```

If many cases should be handled the same way, the branch conditions may be combined with a comma
```kotlin
when (number) {
    1, 2, 3, 4 -> println("the number is 1, 2, 3, or 4")
    8 -> println("the number is 8")
    else -> println("the number is something else")
}
```

## Classes
```kotlin
package classes
```

### Classes
`src/main/kotlin/classes/Class.kt`


We can declare a class without constructor or body
```kotlin
class Garden
val myGarden: Garden = Garden()
myGarden.toString()
myGarden.hashCode()
```

A class is declared with its primary constructor directly in the class header (first line). Classes contain properties, which are accessed using getters and setters. Classes have their visibility modifiers set to `public` by default.
```kotlin
class StudentSimple constructor(age: Int, school: String,) {

    // the public visibility modifier is used by default, meaning the property is visible everywhere
    public val currentSchool: String = school

    // a private property will not be accessible outside of the class
    // a protected property will only be visible to subclasses
    private var age: Int = age
}
```

We can add functions to classes; and we refer to those as member functions, or methods
```kotlin
class StudentAdvanced constructor(age: Int, school: String,) {

    val currentSchool: String = school
    private var age: Int = age

    fun printSchool(): Unit {
        println("Student goes to: $currentSchool")
    }
}
```

If the primary constructor does not have any annotations or visibility modifiers the constructor keyword can be omitted
```kotlin
class Dog(age: Int) {
    var age: Int = age
    val cute: Boolean = true
}
```

If there are no parameters needed in the primary constructor, even the parens don't need to be there!
```kotlin
class Honeybadger {
    val dontcare: Boolean = true
}
```

Classes can also declare secondary constructors inside the class declaration
```kotlin
class Puffin constructor(age: Int) {
    var ageOfPuffin: Int = age

    constructor() : this(age = 100) {
        println("Secondary constructor was used")
    }

    fun printAge(): Unit {
        println("This puffin is $ageOfPuffin")
    }
}
```

Kotlin creates getters and setters automatically for us but we can declare specific getters and setters
```kotlin
class Bison constructor(age: Int) {
    var ageOfBison: Int = age
        get() {
            println("The getter on this bison's age was run")
            return field - 7
        }
        set(value) {
            println("A trickster has set the new age of this bison")
            field = value + 100
        }
}
```

Kotlin can declare the properties for us if we declare the parameters as val or var in the class header. Those properties will have their getters and setters set by default
```kotlin
class Lion constructor(var age: Int, val name: String) {
    fun printInfo() {
        println("$name the lion is $age years old")
    }
}
```

```kotlin
fun main() {
    val myGarden: Garden = Garden()
    println(myGarden.toString())
    println(myGarden.hashCode())

    val matt: StudentAdvanced = StudentAdvanced(age = 27, school = "Stanford")
    matt.printSchool()
    println(matt.currentSchool)
    println(matt.age) // throws error because age is private to the Student class

    val bitcoin: Honeybadger = Honeybadger()
    println(bitcoin.dontcare)

    // create objects using the primary and secondary constructors
    val henry: Puffin = Puffin(age = 25)
    henry.printAge()
    val arty: Puffin = Puffin()
    arty.printAge()

    // custom getters and setters
    val marty: Bison = Bison(30)
    println(marty.ageOfBison)
    marty.ageOfBison = 24
    println(marty.ageOfBison)

    val sam: Lion = Lion(age = 7, name = "Sam",)
    sam.printInfo()
}
```

We can retrieve the name of the class of an object using the following methods
```kotlin
marty.javaClass.kotlin.simpleName
sam::class.simpleName
```
<br/>

### Enums
`src/main/kotlin/classes/Enums.kt`
We use enums to specify that a variable can only take values from a predetermined set of possible values. A response from a server might require that it either be a SUCCESS or FAILURE, for example, or that the OS option for the user be set to ANDROID, MAC, or LINUX.

```kotlin
enum class Commodities {
    GOLD,
    BITCOIN,
}

fun main() {

    val oneCommodity: Commodities = Commodities.BITCOIN
    println(oneCommodity) // BITCOIN

    val otherCommodity: Commodities = Commodities() // throws error: enum types cannot be instantiated

    fun decideWhatPurchase(volatilityComfort: Boolean): Commodities {
        return when (volatilityComfort) {
            true -> Commodities.BITCOIN
            false -> Commodities.GOLD
        }
    }

    // the example below shows how the purchase variable expects a Commodities enum (GOLD or BITCOIN)
    // anything else will return an error
    val purchase: Commodities = decideWhatPurchase(volatilityComfort = false)
    println("You should purchase: $purchase")
}
```
<br/>

### Init Blocks
`src/main/kotlin/classes/InitBlocks.kt`

If we need to run some code as part of the constructor, we can put that code inside one or more init blocks. Those blocks get executed in order they appear in the class declaration, only once when the object is initialized.
```kotlin
class User constructor(val age: Int) {
    val isAdult: Boolean

    init {
        isAdult = age > 18
        if (isAdult = age > 18) println("User is an adult") else println("User is a child")
    }
}

fun main() {
    val jess = User(age = 9) // instantiating the object will print "User is a child" in this case
    println(jess.isAdult) // false
}
```
<br/>

### Singletons
`src/main/kotlin/classes/Singletons.kt`

A singleton is an class that can only be instantiated once. This is done using a syntax called _object declaration_.
```kotlin
object DatabaseManager {
    fun connectToDatabase(databaseID: Int) {
        println("Connected to database")
    }
}

fun main() {
    // the object's initialization is thread-safe and is done at first access (like below)
    DatabaseManager.connectToDatabase(42)
}
```
<br/>
<br/>

## Interfaces
```kotlin
package classes
```

### Interfaces
`src/main/kotlin/classes/Interfaces.kt`

```kotlin
// interfaces cannot hold state
interface Building {
    fun printObjective(): Unit
    fun returnLocation(): String
}

interface University {
    fun printGorgeousCampus(): Boolean
}
```

A class can implement multiple interfaces.
```kotlin
class School constructor(val location: String, val objective: String): Building, University {

    override fun printObjective() {
        println("School is located in $location")
    }

    override fun returnLocation(): String {
        println("School objective is to $objective")
        return objective
    }

    override fun printGorgeousCampus(): Boolean {
        println("Of course")
        return true
    }
}

class CoffeeShop constructor(val location: String, val objective: String): Building {

    override fun printObjective() {
        println("Coffee shop is located in $location")
    }

    override fun returnLocation(): String {
        println("Coffee shop objective is to $objective")
        return objective
    }
}


fun main() {

    val uOfBritishColumbia: School = School("Vancouver", "teach")
    val hipsterCoffeeShop: CoffeeShop = CoffeeShop("Saskatoon", "sell coffee")

    uOfBritishColumbia.returnLocation()
    hipsterCoffeeShop.printObjective()

    println("uOfBritishColumbia is of school class: ${uOfBritishColumbia is School}")
    println("uOfBritishColumbia implements Building interface: ${uOfBritishColumbia is Building}")
    println("uOfBritishColumbia implements University interface: ${uOfBritishColumbia is University}")
}
```
