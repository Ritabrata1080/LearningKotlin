/**
 * Created by Ritabrata, 25/08/20204
 */

fun main() {

    /**
     * Whereas lists are ordered and allow duplicate items, sets are unordered
     * and only allow unique items
     *
     * To create read-only set, use setOf() and to create mutable set, use mutableSetOf()
     */
    val readOnlyFruit = setOf("Apple", "Cherry", "Banana", "Guava", "Cherry")
    println("ReadOnly set of fruits : $readOnlyFruit")

    val fruits : MutableSet<String> = mutableSetOf("Apple", "Banana", "Mango", "Jackfruit", "Mango")
    println("Mutable set of fruits : $fruits")

    /**
     * To get the number of items in a set, use the .count() method or
     * `.size` attribute to know the length of the set
     */
    println("The fruit set has ${fruits.count()} fruits")

    /**
     * To check if an item is present in the set, use the `in` operator. It checks for case-sensitive values
     */
    println("Banana" in readOnlyFruit)

    /**
     * To add/remove items from a mutable set, use .add() or .remove() functions
     */
    fruits.add("Pineapple")
    fruits.remove("Jackfruit")
    println("Updated fruit set : $fruits")
}
