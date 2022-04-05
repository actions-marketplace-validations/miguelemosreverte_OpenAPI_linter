package format

trait Format[A] {
  def format: A => String
}

// typeclass pattern
object Format {
  def printer[A](a: A)(implicit formatter: Format[A]): String =
    formatter.format(a)
}
