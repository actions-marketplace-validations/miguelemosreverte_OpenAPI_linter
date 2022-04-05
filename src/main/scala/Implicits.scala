import scala.util.Try

object Implicits {
  implicit class TryOr[A](e: Try[A]) {
    def or[E](ee: Throwable => E): Either[E, A] =
      e.toEither.left.map(ee)
  }
  implicit class EitherOr[A, B](e: Either[A, B]) {
    def or[C](ee: A => C) =
      e.left.map(ee)
  }
}
