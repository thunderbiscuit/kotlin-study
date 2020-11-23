package data

// strings are enclosed between double quotes
// you can escape characters using the \ character
val hello: String = "hello"
val whatsupdog: String = "What's \"updog\"?"



// you can build strings using string templates
fun printGreetings(greeting: String, age: Int) {
    println("$greeting, world!")
    println("You'll be ${age + 10} in 10 years!")
}



fun main() {
    println(hello)
    println(whatsupdog)

    printGreetings(hello, 42)
}
