/**
  * Created by Chandan Suri on 12/30/2016.
  */
object listFun {

  val nums = List(2, -8, 6, 0, 22, 10,6)
  val fruits = List("apple","pineapple","orange","banana")

  nums filter(x => x>0)
  nums filterNot(x => x>0)
  nums partition(x => x>0)
  nums takeWhile(x => x>0)
  nums dropWhile(x => x>0)
  nums span(x => x>0)

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span(y => y==x)
      first :: pack(rest)
  }

  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map(ys => (ys.head, ys.length))
}
