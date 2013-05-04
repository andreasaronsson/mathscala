

import scala.Array.canBuildFrom

object Mean {

  def main(args: Array[String]) {
    val intargs = args map (_.toInt)
    val sum = intargs reduceLeft (_ + _)
    println("Mean: " + sum / intargs.length)
  }
}
