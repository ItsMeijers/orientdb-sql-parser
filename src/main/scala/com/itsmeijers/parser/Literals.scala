package com.itsmeijers.parser

import fastparse.all._

/**
  * Literals for the Extended SQL DSL for OrientDB
  */
object Literals {

//    {
//        < INTEGER_LITERAL:
//        <DECIMAL_LITERAL> (["l","L"])?
//            | <HEX_LITERAL> (["l","L"])?
//            | <OCTAL_LITERAL> (["l","L"])?
//                >
//                |
//                < #DECIMAL_LITERAL: ["1"-"9"] (["0"-"9"])* >
//                    |
//                    < #HEX_LITERAL: "0" ["x","X"] (["0"-"9","a"-"f","A"-"F"])+ >
//                        |
//                        < #OCTAL_LITERAL: "0" (["0"-"7"])* >

  val DECIMAL_LITERAL = P(CharIn('1' to '9')) ~ P(CharIn('0' to '9')).rep

  val HEX_LITERAL = P("")

  val OCTAL_LITERAL = P("")

  val INTEGER_LITERAL = DECIMAL_LITERAL ~ P(IgnoreCase("L")).? |
    HEX_LITERAL ~ P(IgnoreCase("L")).?   |
    OCTAL_LITERAL ~ P(IgnoreCase("L")).?

}
