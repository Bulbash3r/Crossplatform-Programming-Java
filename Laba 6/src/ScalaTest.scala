import org.scalatest._

class ScalaTest extends FlatSpec with Matchers {

  "Average" should "Norm" in {
    assert (Laba6.Average(List(1))==1)
  }

  it should "Average" in {
    val source = List (1)
    val answer = 1
    assert (Laba6.Average(source) == answer)
  }
}