package models


sealed trait Hand {
  val id: Int

  def against(other: Hand): GameResult = {

    if (other.id == this.id)
      Tie
    else {
      if ((other.id - this.id).abs % 2 == 0) {
        if (other.id > this.id) Lost else Won
      }
      else {
        if (other.id > this.id) Won else Lost
      }
    }
  }
}

object Hand {
  case object Rock extends Hand {
    val id = 1
  }

  case object Lizard extends Hand {
    val id = 2
  }

  case object Spock extends Hand {
    val id = 3
  }

  case object Scissor extends Hand {
    val id = 4
  }

  case object Paper extends Hand {
    val id = 5
  }

  def getRandomHand(): Either[String, Hand] = {
    val hand1 = scala.util.Random.nextInt(5) + 1
    fromUserInput(hand1)

  }

  def fromUserInput(input: Int): Either[String, Hand] = {

    input match {
      case 1 => Right(Rock)
      case 2 => Right(Lizard)
      case 3 => Right(Spock)
      case 4 => Right(Scissor)
      case 5 => Right(Paper)
      case _ => Left("Enter the right hand")
    }
  }
}