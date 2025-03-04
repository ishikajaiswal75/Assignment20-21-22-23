
package Assignment21

object TransactionValidationTest {
  def main(args: Array[String]): Unit = {
    println("Testing UsingEither.safeDivide Function")
    println(s"10 / 2: ${UsingEither.safeDivide(10, 2)}")  // Expected: Right(5.0)
    println(s"5 / 0: ${UsingEither.safeDivide(5, 0)}")    // Expected: Left("Error: Divide by zero not allowed")
    println(s"9 / 3: ${UsingEither.safeDivide(9, 3)}")    // Expected: Right(3.0)

    println("\n Testing EitherFlatMap.processTransaction Function")
    println(s"Process transaction (500, 50): ${EitherFlatMap.processTransaction(500, 50)}") // Expected: Right(405.0)
    println(s"Process transaction (80, 50): ${EitherFlatMap.processTransaction(80, 50)}")  // Expected: Left("Error: only discount on above 100")
    println(s"Process transaction (30, 50): ${EitherFlatMap.processTransaction(30, 50)}")  // Expected: Left("Error: Insufficient Balance")
    println(s"Process transaction (500, -10): ${EitherFlatMap.processTransaction(500, -10)}") // Expected: Left("Error: amount can not be negative")

    println("\n Testing ErrHndlngWidEither.deposit Function")
    println(s"Deposit (500, 100): ${ErrHndlngWidEither.deposit(500, 100)}") // Expected: Right(600)
    println(s"Deposit (500, -50): ${ErrHndlngWidEither.deposit(500, -50)}") // Expected: Left("Error: deposite amount should be greater than zero")

    println("\n Testing ErrHndlngWidEither.withdraw Function")
    println(s"Withdraw (500, 200): ${ErrHndlngWidEither.withdraw(500, 200)}") // Expected: Right(300)
    println(s"Withdraw (500, 600): ${ErrHndlngWidEither.withdraw(500, 600)}") // Expected: Left("Insufficient Balance")
    println(s"Withdraw (500, -50): ${ErrHndlngWidEither.withdraw(500, -50)}") // Expected: Left("Error: withdraw amount should be greater than zero")

    println("\nTesting ErrHndlngWidEither.processTransaction Function")
    println(s"Transaction (deposit 100): ${ErrHndlngWidEither.processTransaction(500, 100, isDeposit = true)}") // Expected: "Transaction Successful! New balance: $600"
    println(s"Transaction (withdraw 600): ${ErrHndlngWidEither.processTransaction(500, 600, isDeposit = false)}") // Expected: "Transaction Failed: Error: Insufficient balance."
  }
}
