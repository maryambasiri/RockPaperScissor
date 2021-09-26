package models

import models.Hand.{Scissor, fromUserInput}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HandTest extends AnyFlatSpec with Matchers {


  behavior of ("Hand")
  it should "determine the winner" in {
    val hand1 = Hand.Rock
    val hand2 = Hand.Scissor
    val result = hand1.against(hand2)
    result shouldBe Won

  }
  it should "determine the tie" in {
    val hand1 = Hand.Rock
    val hand2 = Hand.Rock
    val result = hand1.against(hand2)
    result shouldBe Tie

  }
  it should "determine the loser" in {
    val hand1 = Hand.Rock
    val hand2 = Hand.Paper
    val result = hand1.against(hand2)
    result shouldBe Lost

  }
  it should "determine the winner of lizard " in {
    val hand1 = Hand.Lizard
    val hand2 = Hand.Paper
    val result = hand1.against(hand2)
    result shouldBe Won

  }
  it should "determine the loser of Paper" in {
    val hand1 = Hand.Paper
    val hand2 = Hand.Lizard
    val result = hand1.against(hand2)
    result shouldBe Lost

  }

  it should "Determine the hand of user input" in {
    val hand: Either[String, Hand] = fromUserInput(4)
    hand match {
      case Left(_) => fail
      case Right(value) => value shouldBe Scissor
    }
  }

  it should "Determine the error of user input" in {
    val hand: Either[String, Hand] = fromUserInput(8)
    hand match {
      case Left(_) => succeed
      case Right(_) => fail
    }
  }
}
