package Assignment22

import scala.util.{Try, Success, Failure}

object TryExample2 {
  def main(args: Array[String]): Unit = {
    // Step 1: Try block to handle exceptions
    val result = Try(10 / 2) // Safe computation (Success(5))
    val errorResult = Try(10 / 0) // This will throw an error (Failure)

    // Step 2: Using map (Transforming value if Success)
    val mappedResult = result.map(_ * 2) // If Success(5), it becomes Success(10)

    // Step 3: Using flatMap (Chaining another Try operation)
    val flatMappedResult = result.flatMap(x => Try(x * 2)) // Success(10)

    // Step 4: Pattern Matching to handle Success and Failure cases
    result match {
      case Success(value) => println(s"Success! Result: $value")
      case Failure(exception) => println(s"Error: ${exception.getMessage}")
    }

    errorResult match {
      case Success(value) => println(s"✅ Success! Result: $value")
      case Failure(exception) => println(s"Error: ${exception.getMessage}")
    }

    // Step 5: Printing results
    println(s"Mapped Result: $mappedResult") // Output: Success(10)
    println(s"FlatMapped Result: $flatMappedResult") // Output: Success(10)
  }
}
  
