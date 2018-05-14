case class Parallelepiped (var xp: Int,
                           var yp: Int,
                           var zp: Int) extends Figure (xp, yp) {

  def Parallelepiped (x: Int, y: Int, z: Int) = new Parallelepiped (x, y, z)
  def setZ (Z: Int) {zp = Z}
  def setSize (X: Int, Y: Int, Z: Int) {xp = X; yp = Y; zp = Z}
}
