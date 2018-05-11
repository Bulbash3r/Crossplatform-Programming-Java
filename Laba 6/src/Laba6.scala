import scala.annotation.tailrec

/**
  * Найти среднее арифметическое элементов списка
  * Подсчитать длину списка
  * Отфильтровать последовательность, оставив только элементы типа String.
  */

object Laba6 extends App {

  def Average (list: List[Int]): Double = {

    /*var sum = 0
    for (i <- list.indices) //for (i <- to list.length - 1)
      sum +=list(i)
    sum/list.length
    */

    @tailrec
    def sum(list: List[Int], acc: Int): Int = {
      if (list.nonEmpty) {
        sum (list.tail, acc+list.head)
      }
      else acc
    }
    sum(list, 0)/list.length
  }

  def Length(list: List[Int]): Int = {
    list.foldLeft(0) {(count, _) => count + 1}
  }

  def CheckString (list: List[Any]): List[Any] = {
    list.filter(s => {s.isInstanceOf[String]})
  }

  val task1 = 1::2::3::4::5::6::7::8::9::10::42::Nil
  val task2 = 1::2::3::4::5::Nil
  val task3 = List[Any](21, 1.05, 12.3456789123456789, "Ерат", 'A', "VMSiS", 42)

  println (Average (task1))
  println (Length(task2))
  println (CheckString(task3))
}