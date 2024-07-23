fun main(){
    // var keyword is used when the data inside the variable is mutable.
    // val is used for immutable data storing. The value stored inside a val variable, cannot be changed

    var name = "Steve"
    val userId = 1083
    var address = "Australia"
    println(name)
    println(userId)
    println(address)

    println("====================")

    val a = 80
    val b = 90
    println("Sum of $a and $b is : ${a+b}")

    //a = 10  // This operation is not allowed as we cannot change a variable which is declared as val

    println("===============")

    // Explicit declaration can also be done,
    // however if we don't specify any datatype, kotlin can infer from the value assigned
    var string1 : String = "Hello people!"
    println("String value is : $string1")

}
