package visibilitymodifiers.package1

// if we try to import a private declaration from another file, we get an error
// Cannot access 'privateCallPokemon': it is private in file
// import visibilitymodifiers.package1.privateCallPokemon

fun main() {
    // the calls below refer to elements within the package that are public
    // they do not require imports
    println(pokemonName)
    callPokemon("Bulba")
    val bulbasmooth: Pokemon = Pokemon("Bulbasaur", 1)
    println(bulbasmooth.name)
    bulbasmooth.gainXP(20)
    println(bulbasmooth.xp)



    // private variables, functions, and classes cannot be imported and therefore accessed
    // println(privatePokemonName) // Cannot access 'privatePokemonName': it is private in file
    // privateCallPokemon("Ivysaur") // Cannot access 'privateCallPokemon': it is private in file
    // val ivysmooth: PrivatePokemon = PrivatePokemon("Ivysmooth", 1) // Cannot access 'PrivatePokemon': it is private in file
    // println(ivysmooth.name)
    // note that the gainXP function in PrivatePokemon is public, but because the class is private we cannot access it
    // ivysmooth.gainXP(20)
    // println(ivysmooth.xp)



    // the following declarations have their visibility set as internal
    // they are from the same package and therefore do not need to be imported
    println(internalPokemonName)
    internalCallPokemon("Venusaur")
    val venusmooth: InternalPokemon = InternalPokemon("Venusmooth", 1)
    println(venusmooth.name)
    venusmooth.gainXP(20)
    println(venusmooth.xp)
}
