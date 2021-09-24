package models

object GameRunner {

  def computerVsComputer(): Either[String, Game] = {
    for {
      p1 <- Hand.getRandomHand()
      p2 <- Hand.getRandomHand()
    } yield Game(p1, p2, p1.against(p2))
  }

  def playerVsComputer(hand: Hand): Either[String, Game] = {
    for {
      p1 <- Hand.getRandomHand()
    } yield Game(p1, hand, p1.against(hand))
  }
}
