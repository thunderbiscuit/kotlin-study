package collections

// maps store key-value pairs (also called entries)
// keys are unique, but different keys can be paired with equal values
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
