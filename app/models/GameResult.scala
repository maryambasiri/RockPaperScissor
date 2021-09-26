package models

sealed trait GameResult


case object Won extends GameResult

case object Lost extends GameResult

case object Tie extends GameResult