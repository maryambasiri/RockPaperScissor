import models.{GameRunner, Hand}

import scala.annotation.tailrec
import scala.io.StdIn.{readInt, readLine}

object UI {
  def play(): Unit = {
    println("\nWelcome to RockPaperScissorsLizardSpoke Game!")
    playOnce()
  }

  private def playOnce(): Unit = {
    println(
      """
        |Please choose the game mode you want to play:
        |1) Player Vs Computer
        |2) Computer Vs Computer
        |3) Exit
        |>""".stripMargin
    )
    val chooseModeGame = readLine()
    chooseModeGame match {
      case "1" =>
        val hand = getHandPlayer()
        GameRunner.playerVsComputer(hand) match {
          case Left(_) => println(" Error in game")
          case Right(game) => Util.printResult(game)
        }

        playOnce()
      case "2" =>
        GameRunner.computerVsComputer() match {
          case Left(_) => println(" Error in game")
          case Right(game) => Util.printResult(game)
        }
        playOnce()
      case "3" =>
        println("\nThanks for playing!")
      case _ =>
        println("\nInvalid input. Exiting program.")
    }
  }


  @tailrec
  def getHandPlayer(): Hand = {
    println(
      """
        |Please choose the numbert of your hand:
        |1) Rock
        |2) Lizard
        |3) Spock
        |4) Scissor
        |5) Paper
        |>""".stripMargin
    )
    val chooseHand: Int = readInt()
    val chooseHandH: Either[String, Hand] = Hand.fromUserInput(chooseHand)
    chooseHandH match {
      case Left(_) => getHandPlayer()
      case Right(value) => value
    }
  }
}