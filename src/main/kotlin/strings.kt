/**
 * Created by Ritabrata, 24/08/2024
 */

fun main() {

    val str1: String = "abc 123"
    // Iterating through the string content and printing character by character
    for (c in str1) {
        println(c)
    }

    /**
    String are immutable, once initialized we can't change the value or assign a new value to it.
    All operations that transform/modify a string, returns a new String object, leaving the original string unchanged
     */

    val str2 = "abcd"
    //Creates a new String object and prints
    println("Converting the string to uppercase : ${str2.uppercase()}")
    // Original string remains same
    println("Original string is : $str2")

    /**
     * String concatenation : Strings can be concatenated with other datatypes too as long as the first
     * argument passed, is a string type
     */

    // Here the first argument "abc" must be a string type for the concatenation to happen
    val str3 = "abc" + 1
    println(str3 + "def")

    /**
     * String templates
     */
    val i = 10
    println("i = $i")

    val letters = listOf<Int>(1, 2, 3, 4)
    println("Letters : $letters")
    println("$letters.size is ${letters.size}")
}
