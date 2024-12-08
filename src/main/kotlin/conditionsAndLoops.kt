/**
 * Created by Ritabrata, 8/12/2024
 */

fun main() {
    // if expression
    val a = 2
    val b = 3

    var max = 0
    if (a < b) {
        max = b
    } else {
        max = a
    }

    // As expression
    max = if (a > b) a else b
    println("Max value is : $max")

    val maxLimit = -1;
    val maxOrLimit = if (maxLimit > 0) maxLimit else if (a > b) a else b
    println("Max Limit is $maxOrLimit")

    /**
     * Branches of an if expression can be blocks. In this case, the last expression is the value of a block:
     */

    val maximum = if (a > b) {
        println("$a is greater")
        a + 1 // this last expression gets assigned to maximum if program flow comes to this block
    } else {
        println("$b is greater")
        b + 1
    }
    println("$maximum is maximum")
}
