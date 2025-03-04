package Assignment21

import jdk.jfr.DataAmount

object ErrHndlngWidEither {
   //function to deposite money
  def deposit(balance: Double,amount: Double) :Either[String,Double]={
    if(amount<0)
      Left("Error: deposite amount should be greater than zero")
    else
      Right(balance+amount)
  }

  //function to withdraw money
  def withdraw(balance: Double, amount: Double): Either[String, Double] = {
    if (amount < 0)
      Left("Error: withdraw amount should be greater than zero")
    else if (amount > balance)
      Left("Insufficient Balance")

  else
      Right(balance - amount)
  }

  //function to run a transaction and handle the error
  def processTransaction(balance :Double,amount: Double,isDeposit:Boolean) :String={
    val result=if(isDeposit)
      deposit(balance, amount)
    else withdraw(balance, amount)

    result match
      case Left(errorMsg) =>s"Transaction failed: $errorMsg"
      case Right(newBalance) => s"Transcation Successfull ! New balance:$$newBalance"
  }

// Main function to test our application
def main(args: Array[String]): Unit = {
//  println(processTransaction(500, 100, isDeposit = true))   // Deposit Success
//  println(processTransaction(500, -50, isDeposit = true))   // Invalid Deposit Amount
//  println(processTransaction(500, 600, isDeposit = false))  // Insufficient Balance
//  println(processTransaction(500, 200, isDeposit = false))  // Withdrawal Success

  println(deposit(500, 100)) // Output: Right(600)
  println(deposit(500, -50)) // Output: Left("Error: Deposit amount should be greater than zero.")
  println(withdraw(500, 200)) // Output: Right(300)
  println(withdraw(500, 600)) // Output: Left("Error: Insufficient balance.")
  println(withdraw(500, -50)) // Output: Left("Error: Withdrawal amount should be greater than zero.")
  println(processTransaction(500, 100, isDeposit = true))
  // Output: "Transaction Successful! New Balance: $600"

  println(processTransaction(500, 600, isDeposit = false))
  // Output: "Transaction Failed: Error: Insufficient balance."

}
}