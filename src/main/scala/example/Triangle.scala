package example

import oscar.cp._

object Triangle extends CPModel with App {

  val max = 200

  val X = CPIntVar(1 to max)
  val Y = CPIntVar(1 to max)

  val H = CPIntVar(1 to max)

  add(X * X + Y * Y === H * H)
  add(X + Y + H < 200)

  search {
    binaryLastConflict(Array(X, Y, H))
  } onSolution {
    println(
      s"Solution found, value of (X,Y,H) in this solution: + (${X.value},${Y.value},${H.value})}"
    )
  }

  val stats = start()
  println(stats)
}
