package data

fun main() {

    data class FamousPerson(val nationality: String, val talents: String)
    val Adele: FamousPerson = FamousPerson("British", "Singer")

    // Kotlin has a syntax called destructuring declaration, which creates multiple variables at once
    // data class FamousPerson(val nationality: String, val talents: String)
    val (adeleNationality: String, adeleTalents: String) = Adele

    println(Adele.nationality)
    println(Adele.talents)

    println(adeleNationality)
    println(adeleTalents)

    // a destructuring declaration is compiled down to the following code
    val adeleNationality2: String = Adele.component1()
    val adeleTalents2: String = Adele.component2()



    // a great way to traverse a map is using function declarations
    val months: Map<String, String> = mapOf("January" to "very cold", "February" to "cold", "March" to "not bad", "April" to "warm", "May" to "awesome!")
    for ((month, temperature) in months) {
        println("$month is $temperature")
    }

    // if you don't need a variable, you can place an underscore instead of naming it
    for ((_, temperature) in months) {
        println("$temperature")
    }
}
