import org.scalatest._

import scala.Array.ofDim

class GameTest  extends FunSpec with Matchers  {
  it ("Null Population Never changes") {
    var matrix = ofDim[Integer](2, 2)
    matrix(0)(0) = 0
    matrix(0)(1) = 0
    matrix(1)(0) = 0
    matrix(1)(1) = 0
    new GameofLife().Live(matrix, 2, 2, 2).sameElements(matrix)
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

    new GameofLife().Live(matrix, 2, 2, 1).sameElements(result)
  }

  it ("Computes Big Matrix Correctly") {
    var matrix = ofDim[Integer](5, 5)
    matrix(0)(0) = 1
    matrix(0)(1) = 1
	  matrix(0)(2) = 0
    matrix(0)(3) = 1
    matrix(0)(4) = 1
    matrix(1)(0) = 0
    matrix(1)(1) = 1
    matrix(1)(2) = 0
    matrix(1)(3) = 1
    matrix(1)(4) = 1
    matrix(2)(0) = 0
    matrix(2)(1) = 0
    matrix(2)(2) = 0
    matrix(2)(3) = 1
    matrix(2)(4) = 1
    matrix(3)(0) = 1
    matrix(3)(1) = 1
    matrix(3)(2) = 0
    matrix(3)(3) = 1
    matrix(3)(4) = 0
    matrix(4)(0) = 0
    matrix(4)(1) = 0
    matrix(4)(2) = 0
    matrix(4)(3) = 0
    matrix(4)(4) = 0
	
    var result = ofDim[Integer](5, 5)

	  result(0)(0) = 1
    result(0)(1) = 1
    result(0)(2) = 0
    result(0)(3) = 1
    result(0)(4) = 1
    result(1)(0) = 1
    result(1)(1) = 1
    result(1)(2) = 0
    result(1)(3) = 0
    result(1)(4) = 0
    result(2)(0) = 1
    result(2)(1) = 1
    result(2)(2) = 0
    result(2)(3) = 0
    result(2)(4) = 0
    result(3)(0) = 0
    result(3)(1) = 0
    result(3)(2) = 1
    result(3)(3) = 1
    result(3)(4) = 1
    result(4)(0) = 0
    result(4)(1) = 0
    result(4)(2) = 0
    result(4)(3) = 0
    result(4)(4) = 0

    new GameofLife().Live(matrix, 5, 5, 1).sameElements(result)

  }
}