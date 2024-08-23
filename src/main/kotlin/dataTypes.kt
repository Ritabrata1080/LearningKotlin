/*
Created by Ritabrata, 23/07/2024
 */
fun main() {
    // Declaring a variable without initialization is allowed in Kotlin
    val variable : Int
    // Initializing the variable
    variable = 20
    // Printing the value of the variable
    println(variable)
    val number1: Int = 34
    val number2: Byte = 12
    val number3: Short = 34
    val number4: Long = 2343224
    val marks : Float = 34.2F
    val marksInDouble : Double = 34.12
    val grade : Char = 'A'
    val isPass : Boolean = true

    // Explicit declaration of variable data type
    val userName : String = "Android Developer"
    val message : String = "This code file needs to get merged"

    var myHobbies : Array<String> = arrayOf("Cricket", "Coding", "Music", "Travelling")

    println("Number1 : $number1")
    println("Number2 : $number2")
    println("Number3 : $number3")
    println("Number4 : $number4")
    println("marks : $marks")
    println("marksInDouble : $marksInDouble")
    println("Grade : $grade")
    println("Passed : $isPass")

    println("User name is : $userName")
    println("Message for user : $message")

    //Iterating over an array of strings
    print("Array contents : ")
    for (item in myHobbies){
        print("$item ")
    }
}
