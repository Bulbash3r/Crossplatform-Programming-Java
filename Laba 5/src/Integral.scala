object Integral extends App {

  /**
    * Вычисление частичной суммы интеграла
    * @param DeltaX приращение по Х
    * @param a нижний предел интегрирования
    * @param b верхний предел интегрирования
    * @return частичная сумма интеграла
    */
  def integral (DeltaX: Double, a: Double, b: Double): Double = {
    f(a) * DeltaX + (f(a + DeltaX) - f(a)) * DeltaX / 2
  }

  /**
    * Вычисление y по x
    * @param x значение переменной
    * @return значение функции в точке х
    */
  def f (x: Double): Double = {
    5 * x * x - 3 * x + 5
  }

}