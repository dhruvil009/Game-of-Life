import scala.Array.ofDim
import scala.util.Random

object GameofLife {
  def main(args: Array[String]) = {
    Life(50, 20, 200)
  }

  def Life(rows: Int, cols: Int, gen: Int) = {
    var generation = ofDim[Integer](rows, cols)
    for (i <- 0 to rows-1) {
      for ( j <- 0 to cols-1) {
        generation(i)(j) = Random.nextInt(2)
      }
    }
    /*to handle cells on the edge, we initialize matrix tempgeneration and embed the generation matrix into it such that generation
    * matrix now has a one cell wide border on all sides. This will prevent from running into edge cases*/
    var tempgeneration = ofDim[Integer](rows+2, cols+2)
    for (i <- 0 to rows+1) {
      for ( j <- 0 to cols+1) {
        tempgeneration(i)(j) = 0
      }
    }
    for (i <- 1 to rows) {
      for ( j <- 1 to cols) {
        tempgeneration(i)(j) = generation(i-1)(j-1)
      }
    }
    Live(tempgeneration,rows+2,cols+2,gen)
  }


  def Live(generation: Array[Array[Integer]], rows: Int, cols: Int, gen : Int): Unit = {
    if(gen<1) {
      return 0
    }
    printf("Generation %3d\n",gen)
    for (i <- 1 to rows-2) {
      for ( j <- 1 to cols-2) {
        if (generation(i)(j) == 1) {
          printf("o")
        }
        else printf(" ")
      }
      printf("\n")
    }
    val nextgen = generation.map(_.clone)

    for (i <- 1 to rows-2) {
      for ( j <- 1 to cols-2) {
        var neighbours = generation(i-1)(j) + generation(i+1)(j) + generation(i)(j-1) + generation(i)(j+1)
        + generation(i-1)(j-1) + generation(i-1)(j+1) + generation(i+1)(j-1) + generation(i+1)(j+1)
        + generation(i-1)(j-1)
        if(generation(i)(j) == 0)
          {
            if(neighbours == 3) nextgen(i)(j) = 1
            else nextgen(i)(j) = 0
          }
        else
          if(neighbours == 2 || neighbours == 3 ) nextgen(i)(j) = 1
          else nextgen(i)(j) = 0
      }
    }
    Live(nextgen,rows,cols,gen-1)
  }
}