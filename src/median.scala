


import scala.Array.canBuildFrom

object Median {

  def main(args : Array[String]) {
    val intargs = args map (_.toInt)
    val (lower, upper) = intargs.sortWith(_<_).splitAt(intargs.size / 2)
    var median:Double = 0;
    if (intargs.size % 2 == 0) {
      median = (lower.last + upper.head) / 2.0 
    } else 
      median = upper.head

    println("Median: " + median)
  }
}
