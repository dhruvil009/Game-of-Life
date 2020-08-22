import code.GameofLife
import org.scalatest._

import scala.Array.ofDim

class GameTest extends GameofLife {
  val matrix = ofDim[Integer](5, 5)

  it ("Computes Matrix Correctly") {
    Live(matrix, 5, 5, 2) should be (matrix)
  }
}