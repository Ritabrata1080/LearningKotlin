/**
Created by Ritabrata
 */

import java.io.File
import java.time.ZonedDateTime
import javax.sql.DataSource

fun main() {

    val fileName = File("hello.txt")
    val sessionStorage1 = SessionStorage(fileName)
    val sessionStorage2 = SessionStorage(fileName)
    // prints false as both refers to different object due to constructor initialization
    println(sessionStorage2 == sessionStorage1)
    println("=============================")

    var dataClassObject = Person(
        "Ritabrata", "ritabrata@gmail.com",
        1, "Associate Software engineer"
    )
    dataClassObject.print()
    println("=============================")

    var obj = DateUtil.format(ZonedDateTime.now())
    println(obj)
    println("=============================")

    val response = HttpStatus.OK
    println(response.toResponseString())
    println("=============================")

    // Iterate through the enum class values
    HttpStatus.values().forEach {
        println(it.name)
    }
    println("=============================")

    val errors = listOf(
        IOError.DatabaseError(), IOError.NetworkError(),
        IOError.UnknownError()
    )
    errors.forEach {
        println(it.message)
    }
}

/**
 * Normal class -
 * 1. The class has a constructor
 * 2. The class has an internal state (member variables that may change over time)
 */
class SessionStorage(
    private var file: File
) {
    private var counter = 0;
    fun utilityFunction(value: String) {
        // TODO
        counter++;
    }
}


/**
 * Data class
 * Takes simple primitives, or a simple list or may be a string that bundles
 * to a unified data structure
 */

data class Person(
    var name: String,
    var email: String,
    var personId: Int,
    var designation: String
) {
    /**
     * lateinit is used if a member variable is guaranteed to be initialized in future
     * Properties of primitive data types (e.g., Int, Double), as well as nullable properties, can’t be declared using “lateinit”.
     */
    private var _name: String
    private var _email: String
    private var _personId: Int = 1
    private lateinit var _designation: String

    // Constructor initialization
    init {
        _name = name
        _email = email
        _personId = personId
        _designation = designation
    }

    fun print() {
        // Check if lateinit type var is initialized
        println("Is lateinit var initialized : ${this::_designation.isInitialized}") // returns true as constructor initalization is done
        println("===============================")
        println("Printing the data class object values....")
        println("Name is : $name")
        println("Email is : $email")
        println("Id is : $personId")
        println("Designation is : $designation")

    }

}

/**
 * Singleton class
 *
 * We can't create an instances of this class as this is a singleton class
 * and only can have one instance
 */

object DateUtil {
    fun format(dateTime: ZonedDateTime): String {
        return ".."
    }
}

/**
 * Enum object
 */

enum class HttpStatus(private val code: Int, private val message: String) {
    OK(200, "OK"),
    NOT_FOUND(404, "Bad Request"),
    BAD_REQUEST(400, "Not Found");

    fun toResponseString(): String {
        return "Error $code ==> $message"
    }
}

/**
 * Sealed class
 * Sealed classes and interfaces provide controlled inheritance of your class hierarchies.
 * All direct subclasses of a sealed class are known at compile time.
 * No other subclasses may appear outside the module and package within which the sealed class is defined.
 * The same logic applies to sealed interfaces and their implementations:
 * once a module with a sealed interface is compiled, no new implementations can be created.
 */

// Create a sealed interface

/**
 * A sealed class itself is always an abstract class,
 * and as a result, can't be instantiated directly.
 * However, it may contain or inherit constructors.
 * These constructors aren't for creating instances of the sealed class itself but for its subclasses.
 * Consider the following example with a sealed class called Error and its several subclasses, which we instantiate:
 */
sealed class IOError(val message: String) {
    class NetworkError : Error("Network failure")
    class DatabaseError : Error("Database cannot be reached")
    class UnknownError : Error("An unknown error has occurred")
}

// Sealed interface 'Error' has implementations only in the same package and module
sealed interface ErrorType

// Sealed class 'IOError' extends 'ErrorType' and is extendable only within the same package
sealed class ThreadError() : ErrorType

// Open class 'CustomError' extends 'ErrorType' and can be extended anywhere it's visible
open class CustomError() : ErrorType


/**
 * You can use enum classes within your sealed classes to use enum constants
 * to represent states and provide additional detail.
 * Each enum constant exists only as a single instance, while
 * subclasses of a sealed class may have multiple instances.
 * In the example, the sealed class Error along with its several subclasses,
 * employs an enum to denote error severity. Each subclass constructor initializes
 * the severity and can alter its state:
 */
enum class ErrorSeverity { MINOR, MAJOR, CRITICAL }

sealed class ErrorReading(val severity: ErrorSeverity) {
    class FileReadError(val file: File) : ErrorReading(ErrorSeverity.MAJOR)
    class DatabaseError(val source: DataSource) : ErrorReading(ErrorSeverity.MINOR)
    object RuntimeError : ErrorReading(ErrorSeverity.CRITICAL)
    // Additional error types can be added here
}
