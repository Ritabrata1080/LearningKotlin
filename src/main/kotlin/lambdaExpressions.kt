/**
 * @author Ritabrata
 *
 * lambdaExpressions.kt : Explained functions in kotlin in details
 */

// Way 1 : Normal function
fun upperCaseString(text : String) : String {
    return text.uppercase()
}

/**
 * Lambda expressions can be hard to understand at first glance so let's break it down.
 * Lambda expressions are written within curly braces {}.
 * Within the lambda expression, you write:
 * the parameters followed by an ->.
 * the function body after the ->.
 * In the previous example:
 * text is a function parameter.
 * text has type String.
 * the function returns the result of the .uppercase() function called on text.
 */
fun main() {
    println(upperCaseString("hello"))
    // Using Lambda expressions, the above functionality can be achieved by :
    println({text: String -> text.uppercase()}("hello"))



}
