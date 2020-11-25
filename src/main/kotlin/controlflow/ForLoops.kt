package controlflow

val cities: List<String> = listOf("Vancouver", "Calgary", "Regina", "Toronto", "Ottawa", "Fredericton")

fun main() {
    for (city: String in cities) {
        println(city)
    }
}
