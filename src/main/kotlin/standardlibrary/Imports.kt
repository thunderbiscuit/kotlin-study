// each file declares its belonging to a package with the following statement
// it is customary to have all files in the same directory belong to the same package but it does not have to be so
package standardLibrary

// we import from the Standard Library using statements like the following
// we can rename symbols in their import statements
import kotlin.random.Random
import kotlin.ranges.until as untilButNotIncluding

fun main() {
    // Random
    Random.nextInt(from = 0, until = 5)

    // Ranges
    5.untilButNotIncluding(to = 10)
}
