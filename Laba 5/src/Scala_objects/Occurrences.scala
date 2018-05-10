package Scala_objects

import scala.annotation.tailrec

/**
  * Object to find the number of occurrences of a Char in a String
  */
object Occurrences extends App {

  /**
    * This method compares two char-symbols
    * @param firstChar first symbol
    * @param secondChar second symbol
    * @return 1 if symbols is equal
    *         2 if symbols isn't equal
    */
  def charEquals (firstChar: Char, secondChar: Char): Int = {
    if (firstChar.equals(secondChar)) 1 else 0
  }

  /**
    * Recursive method of counting occurrences of a Char in a String
    * Was used not tail recursion
    * @param source string in which the search is performed
    * @param symbol char that we are looking for in a string
    * @return number of occurrences of a Char in a String
    */
  def occurrences(source: String, symbol: Char): Int = {
    if (source.length() != 0)
        (occurrences(source.substring(0, source.length()-1), symbol)
        + charEquals(symbol, source.charAt(source.length()-1)))
    else 0
  }

  /**
    * Recursive method of counting occurrences of a Char in a String
    * Was used tail recursion
    * @param accumulator number of occurrences
    * @param source string in which the search is performed
    * @param symbol char that we are looking for in a string
    * @return number of occurrences of a Char in a String
    */
  @tailrec
  def tailOccurrences(accumulator: Int, source: String, symbol: Char): Int = {
    if (source.length()==0) accumulator
    else tailOccurrences(accumulator+charEquals(symbol, source.charAt(source.length()-1)),
      source.substring(0, source.length()-1),
      symbol)
  }
}