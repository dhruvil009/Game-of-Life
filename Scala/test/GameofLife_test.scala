import code.GameofLife
import org.scalatest._

import scala.Array.ofDim

class GameTest extends GameofLife {
  it ("Null Population Never changes") {
    var matrix = ofDim[Integer](5, 5)
    Live(matrix, 5, 5, 2) should be (matrix)
  }

  it ("Computes Matrix Correctly") {
    var matrix = ofDim[Integer](5, 5)
    Live(matrix, 5, 5, 2) should be (matrix)
  }
}