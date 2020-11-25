package lambdas

fun main() {

    // anonymous functions do not have a name
    fun(name: String): Unit {
        println("Hello, $name!")
    }

    fun(num1: Int, num2: Int) = num1 + num2

    val x = fun(num1: Int, num2: Int): Int = num1 + num2
    println(x(1, 1))
}
