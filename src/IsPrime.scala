

import scala.Array.canBuildFrom

object IsPrime {

  def isPrime(n: Int): Boolean = {
    !(2 to (n - 1)).exists(n % _ == 0)
  }

  def main(args: Array[String]) {
    val nargs = args map { a => a filterNot (x => x == ',') }
    val intargs = nargs map (_.toInt)
    intargs foreach {
      case x if isPrime(x) => println(x)
      case _ => Nil
    }
  }
}
