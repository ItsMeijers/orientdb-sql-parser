package com.itsmeijers.parser

import fastparse.all._

/**
  * Operators
  */
object Operators {
  val EQ = P("=")

  val LT = P("<")

  val GT = P(">")

  val BANG = P("!")

  val TILDE = P("~")

  val HOOK = P("?")

  val COLON = P(":")

  val LE = P("=<")

  val GE = P(">=")

  val NE = P("!=")

  val NEQ = P("<>")

  val SC_OR = P("||")

  val SC_AND = P("&&")

  val INCR = P("++")

  val DECR = P("--")

  val PLUS = P("+")

  val MINUS = P("-")

  val STAR = P("*")

  val SLASH = P("/")

  val BIT_AND = P("&")

  val BIT_OR = P("|")

  val XOR = P("^")

  val REM = P("%")

  val LSHIFT = P("<<")

  val PLUSASSIGN = P("+=")

  val MINUSASSIGN = P("-=")

  val STARASSIGN = P("*=")

  val SLASHASSIGN = P("/=")

  val ANDASSIGN = P("&=")

  val ORASSIGN = P("|=")

  val XORASSIGN = P("^=")

  val REMASSIGN = P("%=")

  val LSHIFTASSIGN = P("<<=")

  val RSIGNEDSHIFTASSIGN = P(">>=")

  val RUNSIGNEDSHIFTASSIGN = P(">>>=")

  val ELLIPSIS = P("...")

  val NOT = P(IgnoreCase("NOT"))

  val LIKE = P(IgnoreCase("LIKE"))

  val IS = P(IgnoreCase("IS"))

  val BETWEEN = P(IgnoreCase("BETWEEN"))

  val CONTAINS = P(IgnoreCase("CONTAINS"))

  val CONTAINSALL = P(IgnoreCase("CONTAINSALL"))

  val CONTAINSKEY = P(IgnoreCase("CONTAINSKEY"))

  val CONTAINSVALUE = P(IgnoreCase("CONTAINSVALUE"))

  val CONTAINSTEXT = P(IgnoreCase("CONTAINSTEXT"))

  val MATCHES = P(IgnoreCase("MATCHES"))

  val TRAVERSE = P(IgnoreCase("TRAVERSE"))
}
