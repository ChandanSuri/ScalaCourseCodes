/**
  * Created by Chandan Suri on 12/30/2016.
  */
package week6

object polynomials {

  class Poly(val terms: Map[Int, Double]){
    def +(other: Poly) = new Poly(terms ++ (other.terms map adjust))
    def adjust(term: (Int, Double)): (Int, Double)= {
      val (exp, coeff)= term
      terms get exp match {
        case Some(coeff1) => exp -> (coeff+coeff1)
        case None => exp -> coeff
      }
    }
    override def toString: String = (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff+"X^"+exp )mkString "+ "

  }
  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
  val p2 = new Poly(Map(0 -> 3.0, 3 ->7.0))
  p1+p2
}

