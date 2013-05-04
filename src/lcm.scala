

object Lcm {

def gcd(a: Int, b: Int):Int=if (b==0) a.abs else gcd(b, a%b)
def lcm(a: Int, b: Int)=(a*b).abs/gcd(a,b)

 def main(args : Array[String]) {
   if (args.length == 2)
   {
     val n = Integer.parseInt(args(0))
     val m = Integer.parseInt(args(1))
     println(lcm(n, m))
   }
 }
}
