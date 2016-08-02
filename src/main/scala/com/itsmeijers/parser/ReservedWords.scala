package com.itsmeijers.parser

import fastparse.all._

/**
  * Reserved words in extended SQL Syntax
  */
object ReservedWords {

  val SELECT = P(IgnoreCase("SELECT"))

  val INSERT = P(IgnoreCase("INSERT"))

  val UPDATE = P(IgnoreCase("UPDATE"))

  val DELETE = P(IgnoreCase("DELETE"))

  val FROM = P(IgnoreCase("FROM"))

  val WHERE = P(IgnoreCase("WHERE"))

  val INTO = P(IgnoreCase("INTO"))

  val VALUES = P(IgnoreCase("VALUES"))

  val SET = P(IgnoreCase("SET"))

  val ADD = P(IgnoreCase("ADD"))

  val REMOVE = P(IgnoreCase("REMOVE"))

  val AND = P(IgnoreCase("AND"))

  val OR = P(IgnoreCase("OR"))

  val NULL = P(IgnoreCase("NULL"))

  val ORDER = P(IgnoreCase("ORDER"))

  val BY = P(IgnoreCase("BY"))

  val LIMIT = P(IgnoreCase("LIMIT"))

  val RANGE = P(IgnoreCase("RANGE"))

  val ASC = P(IgnoreCase("ASC"))

  val AS = P(IgnoreCase("AS"))

  val DESC = P(IgnoreCase("DESC"))

  val UNSAFE = P(IgnoreCase("UNSAFE"))

  val THIS = P(IgnoreCase("@this"))

  val RID_ATTR = P(IgnoreCase("@rid"))

  val CLASS_ATTR = P(IgnoreCase("@class"))

  val VERSION_ATTR = P(IgnoreCase("@version"))

  val SIZE_ATTR = P(IgnoreCase("@size"))

  val TYPE_ATTR = P(IgnoreCase("@type"))

  val RECORD_ATTRIBUTE = RID_ATTR | CLASS_ATTR | VERSION_ATTR | SIZE_ATTR | TYPE_ATTR

}
