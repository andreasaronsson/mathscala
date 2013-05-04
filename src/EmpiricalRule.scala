

import scala.math._
import scala.Array.canBuildFrom
object EmpiricalRule {

  def trunc2(x: Double) = {
    BigDecimal(x).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  def trunc0(x: Double) = {
    BigDecimal(x).setScale(0, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  def toPercent(p: Int) = p match {
    case 1 => 68
    case 2 => 95
    case 3 => 99.7
  }

  abstract class Location {
    val low: Double
    val high: Double
    val average: Double
  }
  case class Over(low: Double, high: Double, average: Double) extends Location
  case class Under(low: Double, high: Double, average: Double) extends Location
  case class Dual(low: Double, high: Double, average: Double) extends Location
  case class Newt(low: Double, high: Double, average: Double) extends Location

  def findLocation(location: Location) = {
    location match {
      case Newt(l, h, a) if (l > a && h > a) => Over(l, h, a)
      case Newt(l, h, a) if (l < a && h < a) => Under(l, h, a)
      case _ => Dual(location.low, location.high, location.average)
    }
  }

  def ans(first: Double, second: Double, average: Double, floor: Double) = {
    if (first > average) {
      if (second > average) {
        floor
      }
    }
    0
  }

  def main(args: Array[String]) {
    val doubleargs = args map (_.toDouble)
    val average = doubleargs(0)
    val stdDev = doubleargs(1)
    val low = doubleargs(2)
    val numStdToLow = trunc0(((average - low).abs / stdDev)).asInstanceOf[Int]
    val belowPercent = toPercent(numStdToLow)

    if (doubleargs.length > 3) {
      val high = doubleargs(3)
      val numStdToHigh = trunc0(((high - average).abs / stdDev)).asInstanceOf[Int]
      val overPercent = toPercent(numStdToHigh)
      val absDiff = trunc2((belowPercent - overPercent).abs)
      val floorPercent = min(belowPercent, overPercent)
      println("Number of standard deviations to low: " + numStdToLow)
      println("Number of standard deviations to high: " + numStdToHigh)
      println(belowPercent + " " + overPercent)
      println("diff " + absDiff)
      println("Answer: " + (ans(low, high, average, floorPercent) + absDiff / 2) + "%")
    } else {
      println("Longer: " + ((100 - belowPercent) / 2 + belowPercent) + "%")
      println("Less: " + (100 - ((100 - belowPercent) / 2 + belowPercent)) + "%")
    }
  }
}
