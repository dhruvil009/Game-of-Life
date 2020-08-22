import org.scalatest._

import scala.Array.ofDim

class GameTest {
  it ("Null Population Never changes") {
    var matrix = ofDim[Integer](5, 5)
    new GameofLife().Live(matrix, 5, 5, 2) should be (matrix)
  }

  it ("Computes Small Matrix Correctly") {
    var matrix = ofDim[Integer](2, 2)
    matrix(0)(0) = 1
    matrix(0)(1) = 0
    matrix(1)(0) = 0
    matrix(1)(1) = 1

    var result = ofDim[Integer](2, 2)

    result(0)(0) = 1
    result(0)(1) = 0
    result(1)(0) = 0
    result(1)(1) = 1

    new GameofLife().Live(matrix, 2, 2, 1) should be (result)
  }

  it ("Computes Big Matrix Correctly") {
//    ToDo: Sreemoyee

//    new GameofLife().Live(matrix, 2, 2, 1) should be (result)
  }
}