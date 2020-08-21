import scala.Array.ofDim
import scala.util.Random

object GameofLife {
  def main(args: Array[String]) = {
    Life(5, 5)
  }

  def print_matrix(generation: Array[Array[Integer]], rows: Int, cols: Int): Unit = {
    for (i <- 0 to rows-1) {
      for ( j <- 0 to cols-1) {
        if (generation(i)(j) == 1)
          print("o")
        else
          print(" ")
      }
      println();
    }
  }

  def Life(rows: Int, cols: Int) = {
    var generation = ofDim[Integer](rows, cols)
    val rand = new Random(0)
    for (i <- 0 to rows-1) {
      for ( j <- 0 to cols-1) {
        generation(i)(j) = rand.nextInt(2)
      }
    }
    Live(generation, rows, cols, 5)
  }

  def Live(generation: Array[Array[Integer]], rows: Int, cols: Int, gen : Int): Unit = {
    if(gen == 0)
      return
    println("Generation: " + gen)
    print_matrix(generation, rows, cols)
    var nextGen = generation.map(_.clone)
    for (i <- 0 to rows-1) {
      for ( j <- 0 to cols-1) {
        var neighbours = 0
        val rowstart = if (i != 0) i - 1 else i
        val rowend = if (i != rows - 1) i + 1 else i
        val colstart = if (j != 0) j - 1 else j
        val colend = if (j != cols - 1) j + 1 else j

        for (row <- rowstart to rowend) {
          for(col <- colstart to colend) {
            neighbours += generation(row)(col)
          }
        }
        neighbours -= generation(i)(j)

        if(generation(i)(j) == 0)
          nextGen(i)(j) = if (neighbours == 3) 1 else 0
        else
          nextGen(i)(j) = if (neighbours == 2 || neighbours == 3) 1 else 0
      }
    }
    Live(nextGen,rows,cols,gen-1)
  }
}