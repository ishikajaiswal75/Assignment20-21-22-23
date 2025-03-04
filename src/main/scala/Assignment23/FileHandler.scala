package Assignment23

import scala.util.{Using, Try}
import scala.io.Source
import java.io.{File, PrintWriter}


object FileHandler {

  // Function to read a file safely using `Using`
  def readFile(filePath: String): Either[String, String] = {
    Using(Source.fromFile(filePath)) { source =>
      source.getLines().mkString("\n") // Read all lines and join them
    }.toEither.left.map(_ => "Error: Unable to read file!") // Convert to Either for better error handling
  }

  // Function to write to a file safely using `Using`
  def writeFile(filePath: String, content: String): Either[String, String] = {
    Using(new PrintWriter(new File(filePath))) { writer =>
      writer.write(content) // Write content to the file
      content // Explicitly return content to match Either[String, String]
    }.toEither.left.map(_ => "Error: Unable to write to file!") // Convert to Either for error handling
  }

  def main(args: Array[String]): Unit = {
    val filePath = "example.txt"

    // Write operation
    writeFile(filePath, "Hello, this is a test file.") match {
      case Right(_) => println("File written successfully!")
      case Left(errorMessage) => println(errorMessage)
    }

    // Read operation
    readFile(filePath) match {
      case Right(content) => println(" File Content:\n" + content)
      case Left(errorMessage) => println(errorMessage)
    }
  }
}