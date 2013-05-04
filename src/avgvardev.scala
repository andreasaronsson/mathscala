

import scala.math._
import scala.Array.canBuildFrom
object AvgPlusVariance {

  def getAverage(intargs: Array[Int]):Double = intargs.foldLeft(0.0)(_ + _) / intargs.length  
  
  def squaredDifference(value1: Int, value2: Double) = pow(value1 - value2, 2)

  def squared(list: Array[Int], average: Double) = {
    list.foldLeft(0.0)(_ + squaredDifference(_, average))    
  }

  def varianceSample(length: Int, s: Double) = {
    (s / (length.toDouble - 1))
  }

  def variancePop(length: Int, s: Double) = {    
    (s / (length.toDouble))
  }

  def trunc1(x: Double) = {
    BigDecimal(x).setScale(1, BigDecimal.RoundingMode.HALF_UP).toDouble
  }
  
  def main(args : Array[String]) {
    val cleanargs = args(0).split(",")
    val intargs = cleanargs map (_.toInt)
    val average = getAverage(intargs)
    val sq = squared(intargs, average)
    val variSample = varianceSample(intargs.length, sq)
    val variPop = variancePop(intargs.length, sq)
    val sdPop = sqrt(variPop)
    val sdSamp = sqrt(variSample)

    println("Average: " + trunc1(average))
    println("Variance sample: " + trunc1(variSample))
    println("Variance population: " + trunc1(variPop))
    println("Standard deviation population: " + trunc1(sdPop))
    println("Standard deviation sample: " + trunc1(sdSamp))
    
  }
}
