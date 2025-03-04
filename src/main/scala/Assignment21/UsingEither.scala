package Assignment21

object UsingEither {
  def safeDivide(a: Double, b: Double): Either[String, Double] = {
    if (b == 0) {
      Left("Error: Divide by zero not allowed") //Error case
    }
    else {
      Right(a / b) //success case
    }
  }

  def main(args: Array[String]): Unit = {
    val result1 = safeDivide(10, 2)
    val result2 = safeDivide(5, 0)
    val result3 = safeDivide(9, 3)

    println(result1)
    println(result2)
    println(result3)
  }
}
