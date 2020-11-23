package standardLibrary

// we import from the Standard Library using statements like the following
import kotlin.random.Random

// you can rename symbols in their import statements
import kotlin.ranges.until

fun main() {
    // Random
    Random.nextInt(from = 0, until = 5)
    Random.nextDouble()
    Random.nextBoolean()

    // Ranges
    0.until(to = 10)
}
