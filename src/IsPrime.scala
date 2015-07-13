import scala.Array.canBuildFrom

object IsPrime extends App {

  def isPrime(n: Int): Boolean = {
    !(2 to (n - 1)).exists(n % _ == 0)
  }

  def parseArgsToInts(args: Array[String]): Array[Int] = {
    val nargs = args map { a => a filterNot (x => x == ',') }
    nargs map (_.toInt)
  }

  val intargs = parseArgsToInts(args)
  intargs foreach {
    case x if isPrime(x) => println(x)
    case _ => Nil
  }

}
IsPrime.main(args)
