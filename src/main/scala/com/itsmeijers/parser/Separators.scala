package com.itsmeijers.parser

import fastparse.all._

/**
  * Separators Extended SQL OrientDb
  */
object Separators {
  val LPAREN = P("(")

  val RPAREN = P(")")

  val LBRACE = P("{")

  val RBRACE = P("}")

  val LBRACKET = P("[")

  val RBRACKET = P("]")

  val SEMICOLON = P(";")

  val COMMA = P(",")

  val DOT = P(".")

  val AT = P("@")

  val DOLLAR = P("$")

  val BACKTICK = P("`")

}
