package models

sealed trait ResultGame


case object Won extends ResultGame

case object Lost extends ResultGame

case object Tie extends ResultGame