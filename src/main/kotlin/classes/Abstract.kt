package classes

// an abstract class cannot be instantiated
// but subclasses can inherit from them
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
    // fun printAddress(address: String): Unit {
    //     println("Address is $address")
    // }

    // attempting to add the override keyword will not work, as the printAddress function in the abstract method
    // does not have the open modifier, and is therefore final by default
    // override fun printAddress(address: String): Unit {
    //     println("Address is $address")
    // }

    // note that we can define a method with the same name but a different signature, and the compiler will accept it
    fun printAddress(): Unit {
        println("We do not have an address for this house")
    }
}

fun main() {
    val house: House = House(colourOfHouse = "blue", age = 20, material = "stone")

    // calling printAddress from the SmallBuilding class
    house.printAddress("1, North Pole")
    // calling printAddress from the House class
    house.printAddress()
}
