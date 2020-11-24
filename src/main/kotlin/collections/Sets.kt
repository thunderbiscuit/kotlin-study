package collections

// sets store unique elements, and their order is generally undefined
val students: Set<Int> = setOf(0, 12, 20, 24,)



// sets are immutable by default
// we can create mutable sets as well
val animals: MutableSet<String> = mutableSetOf("deer", "bear", "raven")



fun main() {
    println(students)
    println(students.size)
    println(students.contains(12))

    // mutable sets
    println(animals)
    animals.add("beaver")
    println(animals)
}
