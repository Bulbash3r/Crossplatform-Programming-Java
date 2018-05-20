/**
  * Реализовать классы Rectangle и Parallelepiped. Реализовать функцию, производящую
  * расчёт площади поверхности фигуры. Классы должны иметь метод unapply, предоставляющий
  * размеры сторон фигуры
  */
abstract class Figure (var x: Int, var y: Int) {

  /**
    * @return Площадь поверхности
    */
  def area: Int = {
    this match {
      case Rectangle (_, _) => x * y
      case Parallelepiped (_, _, z) => 2 * (x*y + x*z + y*z)
    }
  }

  /**
    * @return Объём фигуры
    */
  def volume: Int = {
    this match {
      case Rectangle (_, _) => 0
      case Parallelepiped (_, _, z) => x * y * z
    }
  }

  /**
    * @return Длины сторон фигуры
    */
  def unapply: Any = {
    this match {
      case Rectangle (_, _) => (x, y)
      case Parallelepiped (_, _, z) => (x, y, z)
    }
  }

  def setX (X: Int): Any = { x = X }

  def setY (Y: Int): Any = { y = Y }
}