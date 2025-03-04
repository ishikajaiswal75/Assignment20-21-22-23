package Assignment21

object TransactionValidationTest {

  // Main function to run all tests
  def main(args: Array[String]): Unit = {
    testProcessTransaction()
    testDeposit()
    testWithdraw()
  }

  // Function to test processTransaction
  def testProcessTransaction(): Unit = {
    println("Running Tests...\n")

    // Test cases
    assert(ErrHndlngWidEither.processTransaction(500, 100, isDeposit = true) == "Transac  tion Successfull ! New balance:$600")
    assert(ErrHndlngWidEither.processTransaction(500, -50, isDeposit = true) == "Transaction failed: Error: deposite amount should be greater than zero")
    assert(ErrHndlngWidEither.processTransaction(500, 600, isDeposit = false) == "Transaction failed: Insufficient Balance")
    assert(ErrHndlngWidEither.processTransaction(500, 200, isDeposit = false) == "Transcation Successfull ! New balance:$300")

    println("All tests passed!")
  }

  // Function to test individual deposit function
  def testDeposit(): Unit = {
    assert(ErrHndlngWidEither.deposit(500, 100) == Right(600))
    assert(ErrHndlngWidEither.deposit(500, -50) == Left("Error: deposite amount should be greater than zero"))

    println("Deposit function tests passed!")
  }

  // Function to test individual withdraw function
  def testWithdraw(): Unit = {
    assert(ErrHndlngWidEither.withdraw(500, 200) == Right(300))
    assert(ErrHndlngWidEither.withdraw(500, 600) == Left("Insufficient Balance"))
    assert(ErrHndlngWidEither.withdraw(500, -50) == Left("Error: withdraw amount should be greater than zero."))

    println("Withdraw function tests passed!")
  }
}
//def testProcessTransaction(): Unit = {
//  println("Running Tests...\n")
//
//  try {
//    // Test cases
//    val result1 = ErrHndlngWidEither.processTransaction(500, 100, isDeposit = true)
//    println(s"Test 1 Output: $result1") // ✅ Debugging Line
//    assert(result1 == "Transaction Successful! New balance:$600")
//
//    val result2 = ErrHndlngWidEither.processTransaction(500, -50, isDeposit = true)
//    println(s"Test 2 Output: $result2") // ✅ Debugging Line
//    assert(result2 == "Transaction failed: Error: deposit amount should be greater than zero")
//
//    val result3 = ErrHndlngWidEither.processTransaction(500, 600, isDeposit = false)
//    println(s"Test 3 Output: $result3") // ✅ Debugging Line
//    assert(result3 == "Transaction failed: Insufficient Balance")
//
//    val result4 = ErrHndlngWidEither.processTransaction(500, 200, isDeposit = false)
//    println(s"Test 4 Output: $result4") // ✅ Debugging Line
//    assert(result4 == "Transaction Successful! New balance:$300")
//
//    println("All tests passed!")
//
//  } catch {
//    case e: AssertionError => println(s"❌ Assertion Failed: ${e.getMessage}")
//    case ex: Exception => println(s"❌ Unexpected Error: ${ex.getMessage}")
//  }
//}
