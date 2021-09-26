import models.Game

object Util {
  def printResult(result: Game) = {

    if (result.hand1 == result.hand2)
      println(
        s"""
           |player1(in computer against player computer is player1) with hand ${result.hand1}
           |player2 with hand ${result.hand2}
           |play is ${result.resultGame}
           |""".stripMargin
      )
    else
      println(
        s"""
           |player1(in computer against player computer is player1) with hand ${result.hand1}
           |player2 with hand ${result.hand2}
           |player1 is ${result.resultGame}
           |""".stripMargin
      )
  }
}
