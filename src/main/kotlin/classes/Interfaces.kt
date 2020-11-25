package classes

// interfaces cannot hold state
interface Building {
    fun printObjective(): Unit
    fun returnLocation(): String
}

interface University {
    fun printGorgeousCampus(): Boolean
}



// a class can implement multiple interfaces
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
