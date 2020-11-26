package visibilitymodifiers.package2

// import visibilitymodifiers.package1.pokemonName
import visibilitymodifiers.package1.callPokemon
import visibilitymodifiers.package1.Pokemon
import visibilitymodifiers.package1.InternalPokemon
import visibilitymodifiers.package1.internalCallPokemon
import visibilitymodifiers.package1.internalPokemonName
import visibilitymodifiers.package1.Trainer

fun main() {
    // the following call doesn't work because even though pokemonName is public, it needs to be imported
    // println(pokemonName) // Error: Unresolved reference: pokemonName

    // the following declarations have their visibility set as public
    // coming from a different package, they need to be imported
    callPokemon("Bulba")
    val bulbasmooth: Pokemon = Pokemon("Bulbasaur", 1)
    println(bulbasmooth.name)
    bulbasmooth.gainXP(20)
    println(bulbasmooth.xp)



    // the following declarations have their visibility set as internal
    // they work because they are imported
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
