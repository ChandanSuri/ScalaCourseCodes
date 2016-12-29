/**
  * Created by Chandan Suri on 12/29/2016.
  */
object rationals extends App{

  val x = new Rational(1,2)
  x.numer
  x.denom

  val y = new Rational(2,3)
  x.add(y)

  val z = new Rational(5,7)
  x.sub(y).sub(z)

  x.less(y)
  x.max(y)

  val strange = new Rational(1,0)
  strange.add(strange)
}

class Rational(x: Int, y:Int) {
  require(y!=0, "Denominator must be non zero")

  private def gcd(a: Int, b: Int): Int = if (b==0) a else gcd(b, a%b)
  private val g = gcd(x,y)
  def numer = x/g
  def denom = y/g

  def less(that: Rational) = numer*that.denom < that.numer*denom

  def max(that: Rational) = if (this.less(that)) that else this

  def add(that: Rational) =
    new Rational(
      numer*that.denom + denom*that.numer,
      denom*that.denom
    )

  def neg: Rational = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)

  override def toString = numer+"/"+denom
}
