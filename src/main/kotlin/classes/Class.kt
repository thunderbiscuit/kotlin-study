package classes

import kotlin.time.days

// we can declare a class without constructor or body
class Garden
// val myGarden: Garden = Garden()
// myGarden.toString()
// myGarden.hashCode()



// class is declared with its primary constructor directly in the class header (first line)
// classes contain properties, which are accessed using getters and setters
class StudentSimple constructor(age: Int, school: String,) {

    // the public visibility modifier is used by default, meaning the property is visible everywhere
    val currentSchool: String = school

    // a private property will not be accessible outside of the class
    // a protected property will only be visible to subclasses
    private var age: Int = age
}



// we can add functions to classes, and we refer to those as methods
class StudentAdvanced constructor(age: Int, school: String,) {

    val currentSchool: String = school
    private var age: Int = age

    fun printSchool(): Unit {
        println("Student goes to: $currentSchool")
    }
}


// if the primary constructor does not have any annotations or visibility modifiers
// the constructor keyword can be omitted
class Dog(age: Int) {
    var age: Int = age
    val cute: Boolean = true
}



// if there are no parameters needed in the primary constructor, they do not need to be there
class Honeybadger {
    val dontcare: Boolean = true
}



// classes can also declare secondary constructors inside the class declaration
class Puffin constructor(age: Int) {
    var ageOfPuffin: Int = age

    constructor() : this(age = 100) {
        println("Secondary constructor was used")
    }

    fun printAge(): Unit {
        println("This puffin is $ageOfPuffin")
    }
}



// Kotlin creates getters and setters automatically for us
// but we can declare specific getters and setters
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



// Kotlin can declare the properties for us if we declare the parameters as val or var in the class header
// those properties will have their getters and setters set by default
class Lion constructor(var age: Int, val name: String) {
    fun printInfo() {
        println("$name the lion is $age years old")
    }
}



fun main() {
    val myGarden: Garden = Garden()
    println(myGarden.toString())
    println(myGarden.hashCode())

    val matt: StudentAdvanced = StudentAdvanced(age = 27, school = "Stanford")
    matt.printSchool()
    println(matt.currentSchool)
    // println(matt.age) // throws error because age is private to the Student class

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
