package collections


// lists are collections of elements in order
// elements can repeat
// elements are accessible by index
val languages: List<String> = listOf("Java", "Kotlin", "Rust",)
val ages: List<Int> = listOf(1, 2, 4,)



// lists can contain elements of different types
val randomData: List<Any> = listOf("Learn Android", 5, "The Honeybadger", 17.2)



// lists are immutable by default, but we can create mutable lists
val cities: MutableList<String> = mutableListOf("Vancouver", "Calgary", "Toronto", "Montreal")



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
