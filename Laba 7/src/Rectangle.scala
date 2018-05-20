case class Rectangle (var xr: Int,
                      var yr: Int) extends Figure (xr, yr) {

  def Rectangle (x: Int, y: Int) = new Rectangle(x, y)
  def setSize (X: Int, Y: Int) {x = X; y = Y}
}