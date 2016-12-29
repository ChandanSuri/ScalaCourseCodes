/**
  * Created by Chandan Suri on 12/29/2016.
  */
package week4

object exprs {

  def show(e: Expr): String = e match {
    case Number(x) => x.toString
    case Sum(l, r) => show(l) + " + " + show(r)
  }

  show(Sum(Number(1), Number(44)))
}
