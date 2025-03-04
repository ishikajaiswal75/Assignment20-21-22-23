package Assignment22

import scala.util.{Try, Success, Failure}

object Tryblock {
  def main(args: Array[String]) : Unit= {
    val result = Try(10 / 0) //throw an exception
    if (result.isSuccess)
      println(s"Result: ${result.get}")
    else
      println(s"something is wrong: ${result.failed.get.getMessage}")
  }
}
