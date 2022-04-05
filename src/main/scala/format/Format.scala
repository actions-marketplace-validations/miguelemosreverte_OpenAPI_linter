package format

trait Format[A] {
  def format: A => String
}
