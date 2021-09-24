import java.io.IOException

import UI.getHandPlayer
import models.{Game, GameRunner}
import zio.{UIO, ZIO}
import zio.console.{Console, getStrLn, putStr, putStrLn}

import scala.annotation.tailrec

object ZioUI {

  def play(): ZIO[Console, Serializable, Unit] =
    for {
      _ <- putStrLn("\nWelcome to RockPaperScissorsLizardSpoke Game!")
      _ <- playOnce()
    } yield ()
  val i: UIO[Int] = ZIO.effectTotal(42)

  private def playOnce(): ZIO[Console, Serializable, Unit] = {
    val printMenu = putStr(
      """
        |Please choose the game mode you want to play:
        |1) Player Vs Computer
        |2) Computer Vs Computer
        |3) Exit
        |>""".stripMargin)
    for {
      userInput <- printMenu *> getStrLn
      r <-
        if(userInput == "1")
          ZIO.fromEither(GameRunner.playerVsComputer(getHandPlayer())).flatMap(result => putStr(result.prettyPrint)) *> playOnce()
        else if(userInput == "2")
          ZIO.fromEither(GameRunner.computerVsComputer()).flatMap(result => putStr(result.prettyPrint)) *> playOnce()
        else if(userInput == "3")
          ZIO.unit
        else
         playOnce()
    } yield r
  }
}
