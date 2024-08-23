/**
 * Created by Ritabrata, 24/08/2024
 */

fun main() {

    /**
    Lists : Ordered collections of items
    Sets : Unique unordered collection of items
    Maps : Sets of key-value pairs where keys are unique and map to only one value
     */

    /**
     * Lists store items in order that they are added and allow duplicates
     * To create read-only list, use listOf()
     * To create mutable list, use mutableListOf()
     */

    // Read-Only list
    val readOnlyShapesImmutableList = listOf("triangle", "square", "rhombus")
    println(readOnlyShapesImmutableList)

    // Mutable list with explicit type declaration
    val shapesMutableList: MutableList<String> = mutableListOf("triangle", "rhombus", "circle")
    println(shapesMutableList)

    /**
     * To prevent unwanted modifications, you can obtain read only views of mutable lists
     * by assigning them to a List:
     */

    val shapes = mutableListOf("cat", "car", "dog")
    shapes.add(1, "man")

    // After assigning the mutable list to a list, it cannot be modified.
    val shapesLocked: List<String> = shapes

    /**
     * To get the first and last element in a list, use .first() and .last() functions
     */

    val listCompany = listOf("Apple", "Meta", "Ivanti", "Amazon", "Microsoft", "Google")
    println("First company of the list : ${listCompany.first()}")
    println("Last company of the list : ${listCompany.last()}")

    /**
     * To get the count of items in a list, use .count() method
     */
    val companies: List<String> = listOf(
        "Apple", "Meta", "Ivanti", "Commvault", "Nutanix", "Amazon",
        "Cisco", "Citrix", "Nokia", "Samsung", "Morgan Stanley", "Microsoft"
    )
    println("There are ${companies.count()} companies in the list")

    /**
     * To check that if an item is in the list, use `in` operator
     */

    println("Nokia" in companies) // returns true

    /**
     * To add/remove items from a mutable list, use .add() and .remove()
     */
    val foodItems : MutableList<String> = mutableListOf("Paneer", "Corn", "Rice", "Drinks", "Pasta")
    // Printing original list of foodItems
    println("Original items in the foodList : $foodItems")
    // Add beans to first index of the list
    foodItems.add(1, "beans")
    // Add cereals at the end of the list
    foodItems.add("cereals")
    println("After adding beans and cereals to the list : $foodItems")
    // Will remove Paneer from list
    foodItems.remove("Paneer")
    // Will remove the first item present in the list
    foodItems.removeAt(0)
    println("After removing Paneer and first element of the list : $foodItems")
}
