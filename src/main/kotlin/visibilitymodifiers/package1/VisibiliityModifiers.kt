package visibilitymodifiers.package1

// TOP-LEVEL DECLARATIONS
// public: visible everywhere
// internal: visible everywhere in the same module
// private: visible only inside the file

// CLASSES AND INTERFACES
// public: any client who sees the declaring class sees its public members
// internal: any client inside this module who sees the declaring class sees its internal members
// private: visible inside the class only
// protected: visible inside the class and all its subclasses



// variables, functions, and classes can be declared right at the top-level of a file (directly in a package)

// the default visibility modifier is public
// val pokemonName: String = "Bulbasaur" is the same as
public val pokemonName: String = "Bulbasaur"

public fun callPokemon(name: String): Unit {
    println("$name! Come!")
}

public class Pokemon constructor(val name: String, var xp: Int) {
    public fun gainXP(amountGained: Int) {
        xp = xp + amountGained
    }
}



// private visibility modifier makes the top-level declarations available only in the file they are created
// private declarations inside classes or main() will not be visible to top-level classes and functions
private val privatePokemonName: String = "Ivysaur"

private fun privateCallPokemon(name: String): Unit {
    println("$name! Come!")
}

private class PrivatePokemon constructor(val name: String, var xp: Int) {
    public fun gainXP(amountGained: Int) {
        xp = xp + amountGained
    }
}



// the internal visibility modifier makes the declaration available only within the same module
internal val internalPokemonName: String = "Venusaur"

internal fun internalCallPokemon(name: String): Unit {
    println("$name! Come!")
}

internal class InternalPokemon constructor(val name: String, var xp: Int) {
    public fun gainXP(amountGained: Int) {
        xp = xp + amountGained
    }
}



// a class can be public but have its members be public/internal/private/protected
public class Trainer constructor(public val name: String, private var age: Int) {
    private fun printName() {
        println("The name of this trainer is $name")
    }
}



fun main() {
    // public
    println(pokemonName)
    callPokemon("Bulba")
    val bulbasmooth: Pokemon = Pokemon("Bulbasmooth", 1)
    println(bulbasmooth.name)
    bulbasmooth.gainXP(20)
    println(bulbasmooth.xp)



    // private
    println(privatePokemonName)
    privateCallPokemon("Ivysaur")
    val ivysmooth: PrivatePokemon = PrivatePokemon("Ivysmooth", 1)
    println(ivysmooth.name)
    ivysmooth.gainXP(20)
    println(ivysmooth.xp)



    // internal
    println(internalPokemonName)
    internalCallPokemon("Venusaur")
    val venusmooth: InternalPokemon = InternalPokemon("Venusmooth", 1)
    println(venusmooth.name)
    venusmooth.gainXP(20)
    println(venusmooth.xp)



    // public class with private members
    val ash: Trainer = Trainer("Ash", 17)
    ash.name
    // ash.age // Cannot access 'age': it is private in 'Trainer'
    // ash.printName() // Cannot access 'printName': it is private in 'Trainer'
}
