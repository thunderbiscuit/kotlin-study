# Kotlin Study 😎

<p style="text-align: right; height: 0px">
  <button class="btn js-toggle-dark-mode" style="position: relative; top: -3rem">Come to the dark side</button>
</p>

This website is the 1-pager version of a series of packages, code samples, and short explorations of the Kotlin language I keep in [this repo](https://github.com/thunderbiscuit/kotlin-study).


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

### Strings
`src/main/kotlin/data/Strings.kt`

Strings are enclosed between double quotes. We can escape characters using the `\` character.
```kotlin
val hello: String = "hello"
val whatsupdog: String = "What's \"updog\"?"
```


We can build strings using string templates
```kotlin
fun printGreetings(greeting: String, age: Int) {
    println("$greeting, world!")
    println("You'll be ${age + 10} in 10 years!")
}

fun main() {
    println(hello)
    println(whatsupdog)

    printGreetings(hello, 42)
}
```
<br/>
<br/>

## Collections
```kotlin
package collections
```

### Lists
`src/main/kotlin/collections/Lists.kt`

Lists are collections of elements in order. Their elements can repeat. Elements are accessible by index.
```kotlin
val languages: List<String> = listOf("Java", "Kotlin", "Rust",)
val ages: List<Int> = listOf(1, 2, 4,)
```


Lists can contain elements of different types
```kotlin
val randomData: List<Any> = listOf("Learn Android", 5, "The Honeybadger", 17.2)
```

Lists are immutable by default, but we can create mutable lists
```kotlin
val cities: MutableList<String> = mutableListOf("Vancouver", "Calgary", "Toronto", "Montreal")
```

```kotlin
fun main() {
    println(languages)
    println(ages)
    println(randomData)

    // we can operate on read-only lists
    println(languages.size)
    println(languages[2])
    println(languages.get(2))
    println(languages.indexOf("Java"))

    // we can modify mutable lists
    cities.add("Ottawa")
    cities.removeAt(0)
    cities.shuffle()
    cities[1] = "Moncton"
    println(cities)
}
```

### Maps
`src/main/kotlin/collections/Maps.kt`

`Map`s store key-value pairs (also called entries). Keys are unique, but different keys can be paired with equal values
```kotlin
val countries: Map<String, String> = mapOf("Canada" to "cold", "United States" to "medium", "Argentina" to "hot")



// mutable maps are basic maps with write operations
val colours: MutableMap<Int, String> = mutableMapOf(1 to "red", 2 to "green", 3 to "blue")



fun main() {
    println(countries)
    println(countries.keys)
    println(countries.values)

    // mutable maps
    println(colours)
    colours.put(4, "brown")
    colours[7] = "white"
    println(colours)
}
```

### Sets
`src/main/kotlin/collections/Sets.kt`

`Sets` store unique elements, and their order is generally undefined
```kotlin
val students: Set<Int> = setOf(0, 12, 20, 24,)



// sets are immutable by default
// we can create mutable sets as well
val animals: MutableSet<String> = mutableSetOf("deer", "bear", "raven")



fun main() {
    println(students)
    println(students.size)
    println(students.contains(12))

    // mutable sets
    println(animals)
    animals.add("beaver")
    println(animals)
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

We can build functions using named arguments which allows us to provide the arguments to the function call in any order. We can use a mix of named arguments and positioned arguments as long all arguments subsequent to the first named argument also be named.
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

### Standard Library
`src/main/kotlin/standardlibrary/Standard.kt`
We import from the Standard Library using statements like the following.
```kotlin
import kotlin.ranges.until

// Random
Random.nextInt(from = 0, until = 5)
Random.nextDouble()
Random.nextBoolean()

// Ranges
0.until(to = 10)
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
<br/>
<br/>

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

### Abstract Classes
`src/main/kotlin/classes/Abstract.kt`

An `abstract` class cannot be instantiated, but subclasses can inherit from them. Class members can also be `abstract`, but they are not required to.
```kotlin
open abstract class SmallBuilding constructor(age: Int, material: String) {

    init {
        println("This small building is $age years old")
    }

    open abstract var colour: String

    open abstract fun changeColour(colour: String)
    
    fun printAddress(address: String): Unit {
        println("The address of the building is $address")
    }
}

class House(colourOfHouse: String, age: Int = 0, material: String = "brick"): SmallBuilding(age, material) {

    override var colour: String = colourOfHouse

    override fun changeColour(newColour: String) {
        println("The new colour of the house is $newColour")
        this.colour = newColour
    }

    // the following method will not compile, as it overrides the printAddress in the abstract class
    fun printAddress(address: String): Unit { // Error: 'printAddress' hides member of supertype 'SmallBuilding' and needs 'override' modifier
       println("Address is $address")
    }

    // attempting to add the override keyword will not work, as the printAddress function in the abstract method
    // does not have the open modifier, and is therefore final by default
    override fun printAddress(address: String): Unit { // 'printAddress' in 'SmallBuilding' is final and cannot be overridden
        println("Address is $address")
    }

    // note that we can define a method with the same name but a different signature, and the compiler will accept it
    fun printAddress(): Unit {
        println("We do not have an address for this house")
    }
}
```

```kotlin
fun main() {
    val house: House = House(colourOfHouse = "blue", age = 20, material = "stone")

    // calling printAddress from the SmallBuilding class
    house.printAddress("1, North Pole")
    // calling printAddress from the House class
    house.printAddress()
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
```

```kotlin
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
<br/>
<br/>

## Lambdas
```kotlin
package lambdas
```

### Lambdas
`src/main/kotlin/lambdas/Lambdas.kt`

```kotlin

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
```

### Anonymous Functions
`src/main/kotlin/lambdas/AnonymousFunctions.kt`


Anonymous functions do not have a name.
```kotlin
fun(name: String): Unit {
    println("Hello, $name!")
}

fun(num1: Int, num2: Int) = num1 + num2

val x = fun(num1: Int, num2: Int): Int = num1 + num2
println(x(1, 1))
```
<br/>
<br/>

## Visibility Modifiers
```kotlin
package visibilitymodifiers.package1
package visibilitymodifiers.package2
```

The following section explores all 4 visibility modifiers:

+ TOP-LEVEL DECLARATIONS
    1. `public`: visible everywhere
    2. `internal`: visible everywhere in the same module
    3. `private`: visible only inside the file  


+ CLASSES AND INTERFACES
    1. `public`: any client who sees the declaring class sees its public members
    2. `internal`: any client inside this module who sees the declaring class sees its internal members
    3. `private`: visible inside the class only
    4. `protected`: visible inside the class and all its subclasses  


It consists of 3 files distributed in 2 packages: 

1. `visibilitymodifiers.package1`
    + `VisibilityModifiers.kt`
    + `OtherClass.kt`
2. `visibilitymodifiers.package2.kt`
    + `Imports.kt`

### Public Visibility
Declarations made at the top levels of files will be accessible everywhere. The declarations we are interested in reside in `VisibilityModifiers.kt` file. Note that files inside the same package do not need to import those declarations to use them, whereas the files in other packages do.

Public visibility for class members works in very similar ways; any client who can see the declaring class will be able to see its `public` members. This means that if a class is set to `private`, for example, and an external client cannot see it, it will of course not be able to see any of the class' members, even if their visibility was set to `public`.

Note that the default visibility for top level declarations _and_ for class members is `public`.
```kotlin
// visibilitymodifiers.package1.VisibilityModifiers.kt
package visibilitymodifiers.package1

public val pokemonName: String = "Bulbacool"

public fun callPokemon(name: String): Unit {
    println("$name! Come!")
}

public class Pokemon constructor(val name: String, var xp: Int) {
    public fun gainXP(amountGained: Int) {
        xp = xp + amountGained
    }
}

fun main() {
    // use of public top-level declarations
    println(pokemonName) // Bulbacool
    callPokemon("Bulbacool") // Bulacool! Come!
    
    // use of public class members
    val bulbasmooth: Pokemon = Pokemon("Bulbasmooth", 1)
    println(bulbasmooth.name) // Bulbasmooth
    bulbasmooth.gainXP(20)
    println(bulbasmooth.xp) // 21
}
```

The calls below refer to elements within the package that are public, and do not require imports
```kotlin
// visibilitymodifiers.package1.OtherClass.kt
package visibilitymodifiers.package1

fun main()
    println(pokemonName) // Bulbacool
    callPokemon("Bulbacool") // Bulbacool! Come!
    val bulbasmooth: Pokemon = Pokemon("Bulbasaur", 1)
    println(bulbasmooth.name) // Bulbasmooth
    bulbasmooth.gainXP(20)
    println(bulbasmooth.xp) // 21
}
```

```kotlin
// visibilitymodifiers.package2.Imports.kt
package visibilitymodifiers.package2

// import visibilitymodifiers.package1.pokemonName // notice we purposely do not import pokemonName
import visibilitymodifiers.package1.callPokemon
import visibilitymodifiers.package1.Pokemon
import visibilitymodifiers.package1.InternalPokemon
import visibilitymodifiers.package1.internalCallPokemon
import visibilitymodifiers.package1.internalPokemonName
import visibilitymodifiers.package1.Trainer

fun main() {
    // the following call doesn't work because even though pokemonName is public, it needs to be imported
    println(pokemonName) // Error: Unresolved reference: pokemonName

    // the following declarations have their visibility set as public
    // once imported, they work just fine
    callPokemon("Bulba")
    val bulbasmooth: Pokemon = Pokemon("Bulbasaur", 1)
    println(bulbasmooth.name)
    bulbasmooth.gainXP(20)
    println(bulbasmooth.xp)
}
```

### Private Visibility
The `private` visibility modifier makes top-level declarations only available within the file in which they are declared, and class members only visible inside the class they belong to.

A class can be public but have some of its members be `public`/`private`/`internal`/`protected`. See the `Trainer` class below.
```kotlin
// visibilitymodifiers.package1.VisibilityModifiers.kt
package visibilitymodifiers.package1

private val privatePokemonName: String = "Ivysaur"

private fun privateCallPokemon(name: String): Unit {
    println("$name! Come!")
}

// notice that even though PrivatePokemon is private, its gainXP method is public
private class PrivatePokemon constructor(val name: String, var xp: Int) {
    public fun gainXP(amountGained: Int) {
        xp = xp + amountGained
    }
}

public class Trainer constructor(public val name: String, private var age: Int) {
    private fun printName() {
        println("The name of this trainer is $name")
    }
}

fun main() {
    println(privatePokemonName)
    privateCallPokemon("Ivysaur")

    val ivysmooth: PrivatePokemon = PrivatePokemon("Ivysmooth", 1)
    println(ivysmooth.name)

    // we can use gainXP() because it is set as public
    ivysmooth.gainXP(20)
    println(ivysmooth.xp)

    // public class with private members
    val ash: Trainer = Trainer("Ash", 17)
    ash.name // Ash
    ash.age // Cannot access 'age': it is private in 'Trainer'
    ash.printName() // Cannot access 'printName': it is private in 'Trainer'
}
```

Trying to import a private top-level declaration from another file will throw an error. Private top-level declarations cannot be imported and therefore accessed.

Both `OtherClass.kt` and `Imports.kt` throw the same types of error, as the declarations are never imported in the first place.
```kotlin
// visibilitymodifiers.package1.OtherClass.kt
package visibilitymodifiers.package1

import visibilitymodifiers.package1.privateCallPokemon // Cannot access 'privateCallPokemon': it is private in file

fun main() {
    println(privatePokemonName) // Cannot access 'privatePokemonName': it is private in file
    privateCallPokemon("Ivysaur") // Cannot access 'privateCallPokemon': it is private in file
    val ivysmooth: PrivatePokemon = PrivatePokemon("Ivysmooth", 1) // Cannot access 'PrivatePokemon': it is private in file
    
    // note that the gainXP function in PrivatePokemon is public, but because the class is private we still cannot access it
    ivysmooth.gainXP(20) // ivysmooth was never instantiated
    println(ivysmooth.xp) // ivysmooth was never instantiated
}

```

### Internal Visibility
The `internal` visibility modifier will simply acts as if the declaration was `public` within the module, and `private` outside of it. 

### Protected Visibility
The `protected` visibility only applies to class members, and will make its declaration appear `private` to all _except_ for its subclasses, where it will be visible.

<script>
const toggleDarkMode = document.querySelector('.js-toggle-dark-mode');

jtd.addEvent(toggleDarkMode, 'click', function(){
  if (jtd.getTheme() === 'dark') {
    jtd.setTheme('light');
    toggleDarkMode.textContent = 'Come to the dark side';
  } else {
    jtd.setTheme('dark');
    toggleDarkMode.textContent = 'Return to the light side';
  }
});
</script>
