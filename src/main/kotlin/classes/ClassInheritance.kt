package classes

open class SmallBuilding1 constructor(age: Int, material: String) {

    init {
        println("This small building is $age years old")
    }

    fun printAddress(address: String) {
        println("The address of the building is $address")
    }
}

class House1(colourOfHouse: String, age: Int = 0, material: String = "brick"): SmallBuilding1(age, material) {

//    fun printAddress(address: String) {
//        println("print address")
//    }
}

fun main() {
    val house: House = House(colourOfHouse = "blue", age = 20, material = "stone")
    house.printAddress()
}
