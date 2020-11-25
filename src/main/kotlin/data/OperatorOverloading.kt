package data

class BasketOfApples constructor(val apples: Int) {
    operator fun plus(otherBasket: BasketOfApples): BasketOfApples {
        return BasketOfApples(apples + otherBasket.apples)
    }
}

fun main() {

    val basket1: BasketOfApples = BasketOfApples(100)
    val basket2: BasketOfApples = BasketOfApples(42)
    println(basket1.apples)
    println(basket2.apples)

    val basket3: BasketOfApples = basket1 + basket2
    println(basket3.apples)
}
