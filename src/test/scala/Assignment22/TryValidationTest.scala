package Assignment22

object TryValidationTest {
  def main(args: Array[String]): Unit = {
    // Test 1: Successful Computation (Success Case)
    val successResult = scala.util.Try(10 / 2) // Should be Success(5)
    assert(successResult.isSuccess, "Test Failed:  got Failure")
    assert(successResult.get == 5, "Test Failed: Expected result 5 but got something else")
    println("Test 1 Passed: Successful computation works correctly!")


    // Test 2: Error Handling (Failure Case)
    val failureResult = scala.util.Try(10 / 0) // Should be Failure
    assert(failureResult.isFailure, "Test Failed: Expected Failure but got Success")
    println("Test 2 Passed: Error handling works correctly!")

    // Test 3: recover should return fallback value
    val recoverResult = failureResult.recover {
      case _: ArithmeticException => 100
    }
        assert(recoverResult.get == 100, "Test Failed: Expected recover value 100 but got something else")
        println("Test 3 Passed: recover provides correct fallback value!")

    // Test 4: recoverWith should return another Try computation
    val recoverWithResult = failureResult.recoverWith {
      case _: ArithmeticException => scala.util.Try(50 / 2)
    }
    assert(recoverWithResult.get == 25, "Test Failed: Expected recoverWith result 25 but got something else")
    println("Test 4 Passed: recoverWith works correctly!")
  }
    }

