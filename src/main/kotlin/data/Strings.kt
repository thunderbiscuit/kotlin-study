package data

// strings are enclosed between double quotes
// you can escape characters using the \ character
val hello: String = "hello"
val whatsupdog: String = "What's \"updog\"?"



// you can build strings using string templates
fun printGreetings(greeting: String) {
    println("$greeting, world!")
}



fun main() {
    println(hello)
    println(whatsupdog)

    printGreetings(hello)
}
