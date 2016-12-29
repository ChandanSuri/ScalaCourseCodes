/**
  * Created by Chandan Suri on 12/30/2016.
  */
package week5

object mergeSort extends App{

  def msort(xs: List[Int]): List[Int] ={
    val n = xs.length/2
    if (n==0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) => {
          if (x<y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
        }
      }

      val (fst,snd) = xs splitAt n
      merge(msort(fst),msort(snd))
    }
  }

  val nums = List(2, -8, 6, 0, 22, 10,6)
  msort(nums)
}
