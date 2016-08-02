package com.itsmeijers.parser

import fastparse.WhitespaceApi
import fastparse.all._

/**
  * Wrapper to skip spaces, tabs, newlines, and cariage return
  */
object Skip {
  val skip = WhitespaceApi.Wrapper {
    NoTrace(" ".rep) | NoTrace("\\\t".rep) | NoTrace("\\\n".rep) | NoTrace("\\\r".rep) | NoTrace("\\\f")
  }
}

