object Occurrences extends App {

  /**
    * Метод, сравнивающий два символа
    * @param a первый символ
    * @param b второй символ
    * @return 1 если символы одинаковые
    *         2 если символы различны
    */
  def charEquals (a: Char, b: Char): Int = {
    if (a.equals(b)) 1 else 0
  }

  /**
    * Рекурсивный метод для нахождения количества вхождений символа в строку
    * @param string строка, в которой производится поиск
    * @param symbol символ, который ищется в строке
    * @return количество вхождений символа в строку
    */
  def occurrences(string: String, symbol: Char): Int = {
    while (string.length() != 0) {
        return (occurrences(string.substring(0, string.length()-1), symbol)
        + charEquals(symbol, string.charAt(string.length()-1)))
    }
    0
  }

  /**
    * Рекурсивный метод дня нахождения количества вхождений символа в строку
    * Хвостовая рекурсия
    * @param accumulator количество вхождений
    * @param string строка, в которой производится поиск
    * @param symbol символ, который ищется в строке
    * @return количество вхождений символа в строку
    */
  def tailOccurrences(accumulator: Int, string: String, symbol: Char): Int = {
    if (string.length()==0) return accumulator
    tailOccurrences(accumulator+charEquals(symbol, string.charAt(string.length()-1)),
      string.substring(0, string.length()-1),
      symbol)
  }
}