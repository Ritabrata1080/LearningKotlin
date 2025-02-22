/**
 * Created by Ritabrata, 21/02/2025
 */

fun main() {
    var computerChoice = ""
    var playerChoice: String
    print("Enter your choice : ")
    playerChoice = readln()
    // Do input validation on player choice
    while (!valid(playerChoice)) {
        print("Please enter Rocker, Paper or Scissor : ")
        playerChoice = readln()
    }
    var randomNumber = (1..3).random() // double dot means inclusive range

    when (randomNumber) {
        1 -> {
            computerChoice = "Rock"
        }

        2 -> {
            computerChoice = "Paper"
        }

        3 -> computerChoice = "Scissor"
    }
    println(computerChoice)

    /**
     * Do case insensitive comparisons
     */
    val winner = when {
        playerChoice.equals(computerChoice, true) -> "Tie"
        playerChoice.equals("Rock", true)
                && computerChoice.equals("Scissor", true) -> "Player"
        playerChoice.equals("Paper", true)
                && computerChoice.equals("Rock", true) -> "Player"
        playerChoice.equals("Scissor", true)
                && computerChoice.equals("Paper", true) -> "Player"
        else -> "Computer"
    }

    when (winner) {
        "Tie" -> println("It's a tie")
        "Player" -> println("Player won")
        else -> println("Computer won")
    }

}

/**
 * Make the function ignore case sensitiveness of input param
 */
fun valid(playerChoice: String): Boolean {
    return (playerChoice.equals("Rock", true)
            || playerChoice.equals("Paper", true)
            || playerChoice.equals("Scissor", true))

}
