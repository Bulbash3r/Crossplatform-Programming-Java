case class Parallelepiped (var xp: Int,
                           var yp: Int,
                           var z: Int) extends Figure (xp, yp) {

  def Parallelepiped (x: Int, y: Int, z: Int) = new Parallelepiped (x, y, z)
  def setZ (Z: Int): Unit = {z = Z}
  def setSize (X: Int, Y: Int, Z: Int): Unit = {x = X; y = Y; z = Z}
}