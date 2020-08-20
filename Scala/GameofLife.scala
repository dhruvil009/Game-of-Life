import scala.Array.ofDim
import scala.util.Random

object GameofLife {
  def main(args: Array[String]) = {
    Life(10, 10)
  }

  def Life(rows: Int, cols: Int) = {
    var generation = ofDim[Integer](rows, cols)
    for (i <- 0 to rows-1) {
      for ( j <- 0 to cols-1) {
        generation(i)(j) = Random.nextInt(2)
      }
    }
  }
}