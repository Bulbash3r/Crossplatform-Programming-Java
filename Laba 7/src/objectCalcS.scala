/**
  * Реализовать функцию calsS(v: Float, t:String): Float, возвращающую
  * пройденное расстояние S за время t со скоростью в метрах в секунду v.
  * Параметр функции t представляет из себя строку с записью времени в секундах,
  * минутах или часах ("3600s", "50m", "1h")
  */
object objectCalcS extends App {
  def calcS (v: Float, t: String): Float = {
    t.charAt(t.length()-1) match {
      case 's' => t.substring(0, t.length()-1).toInt*v
      case 'm' => t.substring(0, t.length()-1).toInt*v*60
      case 'h' => t.substring(0, t.length()-1).toInt*v*60*60
    }
  }
  println (calcS(1, "30s"))
  println (calcS(5, "180m"))
  println (calcS(20, "2h"))

}
