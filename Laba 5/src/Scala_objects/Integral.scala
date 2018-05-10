package Scala_objects

import scala.annotation.tailrec

/**
  * Object to calculate integral of function
  */
object Integral extends App {

  /**
    * Calculation of the integral by the trapezium method
    * @param acc accumulator of value
    * @param deltaX increment by X
    * @param a lower limit of integration
    * @param b upper limit of integration
    * @return value of the integral of the function
    */
  @tailrec
  def integral (acc: Double, deltaX: Double, a: Double, b: Double): Double = {
    if (a>=b) acc
    else integral (acc+(f(a) * deltaX + (f(a + deltaX) - f(a)) * deltaX / 2), deltaX, a+deltaX, b)
  }

  /**
    * Calculation of function at the point X
    * f(x) = 5(x*x) - 3x + 5
    * @param x value of a variable
    * @return value of function
    */
  def f (x: Double): Double = {
    5 * x * x - 3 * x + 5
  }

}