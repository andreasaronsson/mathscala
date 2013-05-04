

import scala.annotation.tailrec
import scala.Array.canBuildFrom

object PermutateUnique {

  def factorial(n: Int): Int = {
    @tailrec
    def factorialAccumulator(accumulator: Int, number: Int): Int = {
      if (number == 1)
        return accumulator
      else 
        factorialAccumulator(accumulator * number, number - 1)
    }
    factorialAccumulator(1, n)
  }

  def main(args : Array[String]) {
    val intargs = args map (_.toInt)
    val numberItemsFac = factorial(intargs(0))
    val nonUnique = factorial(intargs(1))
    println( numberItemsFac / nonUnique )
  }
}
