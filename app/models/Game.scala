package models


case class Game(hand1: Hand, hand2: Hand, resultGame : ResultGame){

  def prettyPrint: String =
    s"""
       |player1(in computer against player computer is player1) with hand $hand1
       |player2 with hand $hand2
       |${if(hand1 == hand2) "play is" else "player1 is "} $resultGame
       """.stripMargin
}
