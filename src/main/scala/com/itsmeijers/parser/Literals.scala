package com.itsmeijers.parser

import fastparse.all._

/**
  * Literals for the Extended SQL DSL for OrientDB
  */
object Literals {

  val DECIMAL_LITERAL = P(CharIn('1' to '9')) ~ P(CharIn('0' to '9')).rep

  val HEX_LITERAL = P("0") ~ P(IgnoreCase("X")) ~ P(CharIn('0' to '9', 'a' to 'f', 'A' to 'F').rep(min = 1))

  val OCTAL_LITERAL = P("0") ~ P(CharIn('0' to '9').rep)

  val INTEGER_LITERAL = DECIMAL_LITERAL ~ P(IgnoreCase("L")).? |
                        HEX_LITERAL     ~ P(IgnoreCase("L")).?     |
                        OCTAL_LITERAL   ~ P(IgnoreCase("L")).?

  // <#HEXADECIMAL_FLOATING_POINT_LITERAL: "0" [(["0"-"9","a"-"f","A"-"F"]("x","X"].md))+ (".")? <HEXADECIMAL_EXPONENT> ([| "0" ["x","X"]("f","F","d","D"].md)?) (["." (["0"-"9","a"-"f","A"-"F"]("0"-"9","a"-"f","A"-"F"].md)*))+ <HEXADECIMAL_EXPONENT> ([| <#HEXADECIMAL_EXPONENT: ["p","P"]("f","F","d","D"].md)?>) ([(["0"-"9"]("+","-"].md)?))+>
  val HEXADECIMAL_FLOATING_POINT_LITERAL = ???

  //<#DECIMAL_FLOATING_POINT_LITERAL: (["." (["0"-"9"]("0"-"9"].md)+))** (<DECIMAL_EXPONENT>)? ([| "." (["0"-"9"]("f","F","d","D"].md)?))+ (<DECIMAL_EXPONENT>)? ([| (["0"-"9"]("f","F","d","D"].md)?))+ <DECIMAL_EXPONENT> ([| (["0"-"9"]("f","F","d","D"].md)?))+ (<DECIMAL_EXPONENT>)? [| <#DECIMAL_EXPONENT: ["e","E"]("f","F","d","D"]>.md) ([(["0"-"9"]("+","-"].md)?))+>
  val DECIMAL_FLOATING_POINT_LITERAL: Parser[Unit] = ???

  //      | <FLOATING_POINT_LITERAL: <DECIMAL_FLOATING_POINT_LITERAL> | <HEXADECIMAL_FLOATING_POINT_LITERAL>>
  val FLOATING_POINT_LITERAL = DECIMAL_FLOATING_POINT_LITERAL | HEXADECIMAL_FLOATING_POINT_LITERAL

  val CHARACTER_LITERAL = P("'")  ~ (
      (P("\\") ~ P(CharIn(Seq('n', 't', 'b', 'r', 'f', '\\', '\'', '\"'))) ~ P(CharIn(Seq('\\', '\'', '\n', '\r')))) |
      (P(CharIn('0' to '7')) ~ P(CharIn('0' to '7')).?) |
      (P(CharIn('0' to '7')) ~ P(CharIn('0' to '7')) ~ P(CharIn('0' to '3')))
    ).rep ~ P("'")

  // <STRING_LITERAL: "\"" (~["\"","\\","\n","\r"]("0"-"7"].md))) | "\\" ([| ["0"-"7"]("n","t","b","r","f","\\","\'","\""].md) ([| ["0"-"3"]("0"-"7"].md)?) ["0"-"7"]("0"-"7".md)"0"-"7"])))** "\"" | "\'" (~[| "\\" (["n","t","b","r","f","\\","\'","\""]("\'","\\","\n","\r"].md) | [(["0"-"7"]("0"-"7"].md))? | ["0"-"7"]("0"-"7".md)"0"-"3"]) ["\'">
  val STRING_LITERAL = ???

}
