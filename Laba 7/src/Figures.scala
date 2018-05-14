object Figures extends App {

  val r = Rectangle (20, 20)
  println (r.unapply)
  println (r.area)
  println (r.volume)
  r.setSize(1, 42)
  println (r.unapply)
  println (r.area)

  println()

  val p = Parallelepiped(10, 20, 30)
  println (p.unapply)
  println (p.volume)
  println (p.area)
}
