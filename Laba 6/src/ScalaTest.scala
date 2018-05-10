import org.scalatest._

class ScalaTest extends FlatSpec with Matchers {

  it should "CheckString" in {
    val source = List[Any](21, 1.05, 12.3456789123456789, "Ерат", 'A', "VMSiS", 42)
    val answer = List[Any]("Ерат", "VMSis")
    assert (Laba6.CheckString(source) == answer)
  }
}