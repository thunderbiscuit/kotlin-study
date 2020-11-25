package classes



// we use enums to specify that a variable can only take values from a predetermined set of possible values
// for example, a response from a server might require that it either be a SUCCESS or FAILURE
enum class Commodities {
    GOLD,
    BITCOIN,
}



fun main() {

    val oneCommodity: Commodities = Commodities.BITCOIN
    println(oneCommodity)

    // val otherCommodity: Commodities = Commodities() // throws error: enum types cannot be instantiated

    fun decideWhatPurchase(volatilityComfort: Boolean): Commodities {
        when (volatilityComfort) {
            true -> return Commodities.BITCOIN
            false -> return Commodities.GOLD
        }
    }

    val purchase: Commodities = decideWhatPurchase(volatilityComfort = false)
    println("You should purchase: $purchase")
}
