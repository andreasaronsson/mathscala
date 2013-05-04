

object PrimeFind {

 def divides(d : Int, n : Int) = {
   (n % d) == 0
 }

 def ld(n : Int) : Int = {
   ldf(2, n)
 }

 def ldf(k : Int, n : Int) : Int = {
   if (divides(k, n)) k
   else if ((k*k) > n) n
   else ldf((k+1), n)
 }

 def factors(n : Int) : List[Int] = n match {
   case 1 => Nil;
   case _ => {
     val p = ld(n)
     p :: factors(n / p)
   }
 }

 def main(args : Array[String]) {
   if (args.length == 1)
   {
     val n = Integer.parseInt(args(0))
     println(factors(n))
   }
 }
}
