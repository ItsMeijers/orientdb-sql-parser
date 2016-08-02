package com.itsmeijers

import fastparse.WhitespaceApi
import fastparse.all._
import com.itsmeijers.parser.Skip
import com.itsmeijers.parser.ReservedWords._

object Main extends App {
  // Main object
  val query = "SELECT * FROM User"

  import fastparse.noApi._
  import Skip.skip._

  /** Literals */

  val Literal = P(AnyChar.rep)

  /** Separators */

  val STAR = P("*")

  /** Operators */

  /**
    * IDENTIFIER
    * <DEFAULT> TOKEN : {
    * <IDENTIFIER: <LETTER> (<PART_LETTER>)**>
    * | <#LETTER: [| <#PART_LETTER: ["0"-"9","A"-"Z","_","a"-"z"]("A"-"Z","_","a"-"z"]>.md)>
    * }
   */
  val LETTER = P(CharIn('a' to 'z', 'A' to 'Z'))

  val PART_LETTER = P(CharIn('a' to 'z', 'A' to 'Z', '0' to '9')) | P("_")

  val IDENTIFIER = LETTER ~ PART_LETTER.rep

  /**
    * SELECT STATEMENT BNF
    * <SELECT> ( Projection )? <FROM> FromClause ( <WHERE> WhereClause )? ( OrderBy )? ( Limit )? ( Range )?
    */

  /** ProjectionItem ( "," ProjectionItem )** */
  val Alias = IDENTIFIER

  // TODO UPDATE LITERALS AND OTHER PROJECT ITEMS
  val ProjectionItem = (STAR | Literal) ~ (AS ~ Alias).?

  val Projection = ProjectionItem.rep(min = 1, sep=",")


  /**
    * "**"
        | ( (   <NULL> | <INTEGER_LITERAL> | <STRING_LITERAL> | <FLOATING_POINT_LITERAL> | <CHARACTER_LITERAL>
                | FunctionCall | DottedIdentifier | RecordAttribute | ThisOperation | InputParameter
            )
            ( <AS> Alias )? )
    */

  /**
    * FromClause    :=    FromItem
    */
  // Add Cluster + RID with brackets
  val IndexIdentifier = P(IgnoreCase("INDEX:")) ~ IDENTIFIER

  /**
    * FromItem    :=    Rid
    * |    <LBRACKET> Rid ( "," Rid )** <RBRACKET>
    * |    Cluster
    * |    IndexIdentifier
    * |    <IDENTIFIER>
    */
  val FromItem = IndexIdentifier | IDENTIFIER

  val FromClause = FromItem
//
//  val ConditionBlock = ???
//
//  /** ParenthesisBlock    :=    <LPAREN> OrBlock <RPAREN> */
//  val ParenthesisBlock = ???
//
//  /** NotBlock    :=    ( <NOT> )? ( ConditionBlock | ParenthesisBlock ) */
//  val NotBlock = NOT.? ~ (ConditionBlock | ParenthesisBlock)
//
//  /** AndBlock    :=    ( NotBlock ) ( <AND> ( NotBlock ) )** */
//  val AndBlock = NotBlock.rep(min = 1, sep = AND)
//
//  /** OrBlock    :=    AndBlock ( <OR> AndBlock )** */
//  val OrBlock = AndBlock.rep(min = 1, sep = OR)
//
//  /**
//    * WhereClause    :=    OrBlock
//    */
//
//  val WhereClause = OrBlock

  val SelectStatement = SELECT ~ Projection.? ~ FROM ~ FromClause //~ (WHERE ~ WhereClause)

  val result = SelectStatement.parse(query)

  println(result)

  println("Parse star")

  val stars = "* AS table_x"

  println(ProjectionItem.parse(stars))


}
