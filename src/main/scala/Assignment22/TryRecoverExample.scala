package Assignment22

import scala.util.{Try,Success,Failure}
object TryRecoverExample {
  def main(args:Array[String]):Unit={
    val result=Try(10/0)  //will throw an error

    //using recover(return a fixed value)
    val recoverResult=result.recover{
      case _:ArithmeticException=>100
    }
 //using recoverWith(return another try)
    val recoverWithResult=result.recoverWith{
      case _:ArithmeticException =>Try(50/2)
    }

    //print result
    println(s"Recover : $recoverResult")
    println(s"RecoverWith :$recoverWithResult")
  }
}
