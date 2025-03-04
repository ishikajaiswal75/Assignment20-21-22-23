package Assignment21

import jdk.jfr.DataAmount

//by using Either's FlatMap functio we can propogate the errors
object EitherFlatMap {
  def ValidateAmount(amount: Double): Either[String, Double] = {
    if (amount > 0) Right(amount)
    else Left("Error: amount can not be negative")
  }

  def checkBalance(balance: Double, amount: Double): Either[String, Double] = {
    if (balance >= amount) Right(balance - amount)
    else Left("Error: Insufficient Balance")
  }

  def applyDiscount(balance: Double): Either[String, Double] = {
    if (balance > 100) Right(balance * 0.9) //10% discount
    else Left("Error: only discount on above 100")
  }

  def processTransaction(balance: Double, amount: Double): Either[String, Double] = {
    ValidateAmount(amount).flatMap(validAmount =>
      checkBalance(balance, validAmount).flatMap(updatedBalance =>
        applyDiscount(updatedBalance)
      )
    )
  }

  def main(args: Array[String]):Unit= {
    // Function Test
    val result1 = processTransaction(500, 50) // Success case
    val result2 = processTransaction(80, 50) // Error in discount step
    val result3 = processTransaction(30, 50) // Error in balance check
    val result4 = processTransaction(500, -10) // Error in amount validation

    println(result1) // Right(405.0)  (500-50 = 450, then 10% discount = 405)
    println(result2) // Left(Error: Discount will be on above 100)
    println(result3) // Left(Error: Insufficient balance!)
    println(result4) // Left(Error: Amount cannot be zero or negative!)

  }
}