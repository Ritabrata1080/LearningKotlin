/**
 * Created by Ritabrata
 */


import java.io.File

// Enum class for different error types
enum class ErrorTypes {
    MAJOR, MINOR, CRITICAL
}

// Sealed class for error representation
sealed class AppError(private val type: ErrorTypes, private val message: String) {
    class MajorError(message: String) : AppError(ErrorTypes.MAJOR, message)
    class MinorError(message: String) : AppError(ErrorTypes.MINOR, message)
    class CriticalError(message: String) : AppError(ErrorTypes.CRITICAL, message)

    fun logError() {
        println("[$type] Error: $message")
    }
}

// Function to demonstrate error handling
fun processFile(filePath: String) {
    try {
        val file = File(filePath)

        // Major Error: File not found
        if (!file.exists()) {
            val criticalError = AppError.MajorError("File doesn't exist")
            criticalError.logError()
            return
        }

        // Attempt to read file
        val content = file.readText()

        // Minor Error: If file is empty or unreadable
        if (content.isEmpty()) {
            println(("Read error: File is empty"))
            return
        }

        println("File read successfully: $filePath")
    } catch (ex: Exception) {
        // Critical Error: Any unexpected runtime exception
        val criticalError = AppError.CriticalError("Runtime error: ${ex.localizedMessage}")
        criticalError.logError()
    }
}

// Testing the function
fun main() {
    processFile("non_existent.txt")  // Simulates a Major error
    processFile("valid_but_empty.txt")  // Simulates a Minor error (assuming it's empty)
    processFile("valid_file.txt")  // Simulates successful execution if the file exists
}
