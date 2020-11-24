// each file declares its belonging to a package with the following statement
// it is customary to have all files in the same directory belong to the same package but it does not have to be so
package standardlibrary


// a number of packages are imported into every Kotlin file by default
// import kotlin.*
// import kotlin.annotation.*
// import kotlin.collections.*
// import kotlin.comparisons.*
// import kotlin.io.*
// import kotlin.ranges.*
// import kotlin.sequences.*
// import kotlin.text.*

// in the case of Kotlin on the JVM, those packages are also imported by default
// import java.lang.*
// import kotlin.jvm.*

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
