


import scala.Array.canBuildFrom

/**
 * Ex: How many numbers between 1 and 100 (inclusive) are divisible by 7 or 6? 
 */
object DivisibleAorB {

  def main(args : Array[String]) {
    val intargs = args map (_.toInt)
    val oneToHundred = 1 to 100
    val divisibleByFirst = oneToHundred filter (x => x % intargs(0) == 0)
    val divisibleBySecond = oneToHundred filter (x => x % intargs(1) == 0)
    val divisibleByEither = divisibleByFirst ++ divisibleBySecond
    val finalSequence = divisibleByEither.sorted.distinct
    println("This is the divisible set: " + finalSequence)
    println("This is the number of elements: " + finalSequence.size)

  }
}
