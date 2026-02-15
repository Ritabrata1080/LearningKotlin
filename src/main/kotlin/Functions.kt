import kotlinx.coroutines.GlobalScope

/**
 * @author Ritabrata
 *
 * Functions.kt : Explained functions in kotlin in details
 */

fun greet(name: String): String {
    return "Hi ${name}, nice to meet you"
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

// Named arguments
/**
 * For concise code, when calling your function, you don't have to include parameter names.
 * However, including parameter names does make your code easier to
 * read. This is called using named arguments. If you do include parameter names,
 * then you can write the parameters in any order.
 */
fun printMessageWithPrefix(message: String, prefix: String) {
    println("$prefix $message")
}

// Default parameters value
/**
 * You can define default values for your function parameters.
 * Any parameter with a default value can be omitted when calling your function.
 * To declare a default
 * value, use the assignment operator = after the type:
 */

fun printMessageWithDefaultParams(message: String, prefix: String = "Default") {
    println("[$prefix] $message")
}

// Function with return
/**
 * If your function doesn't return a useful value then its return type is Unit.
 * Unit is a type with only one value – Unit. You don't have to declare that Unit is returned
 * explicitly in your function body. This means that you don't have to
 * use the return keyword or declare a return type:
 */

fun printMessage(message: String) {
    println("Hello $message")
}

// Single-Expression Functions
/**
 *  You can remove the curly braces {} and declare the function body using the assignment operator =.
 *  And due to Kotlin's type inference, you can also omit the return type
 */
fun sumShortened(x: Int, y: Int) = x + y

fun main() {
    val output = greet("Coders")
    println(output)
    println(sum(2, 3))
    // Uses named arguments with swapped parameter order
    printMessageWithPrefix(prefix = "Hello", message = "world") // Hello World
    // Function called with both parameters
    printMessageWithDefaultParams("Hello", "World") // [World] Hello
    printMessageWithDefaultParams("Hello") // [Default] Hello
    printMessageWithDefaultParams(prefix = "Hi", message = "There") // [Hi] There
    printMessage("People") // Hello People
    println(sumShortened(2, 33)) // 35
}
