package assignment23

import scala.util.{Using, Try}
import scala.io.Source
import java.io.{File, PrintWriter}


object FileHandlerTest {

  // Test 1: Check if the file closes after reading
  def testReadFileClosing(): Unit = {
    val filePath = "testfile.txt"
    writeFile(filePath, "Test data") // Create a test file

    val fileContent = Using(Source.fromFile(filePath)) { source =>
      println("Reading file...") // Log reading
      source.getLines().mkString("\n")
    }

    // File should close automatically, checking by reading again
    println("Checking if file is closed...")

    fileContent match {
      case scala.util.Success(content) =>
        println(s"File read successfully: $content")
      case scala.util.Failure(ex) =>
        println(s"Failed to read file: ${ex.getMessage}")
    }
  }

  // Test 2: Verify missing file handling
  def testMissingFileHandling(): Unit = {
    val filePath = "nonexistent.txt"

    val result = readFile(filePath)
    println("Testing missing file scenario...")
    result match {
      case Right(content) => println(s"Unexpected success! Content: $content")
      case Left(errorMessage) => println(s"Correctly handled missing file: $errorMessage")
    }
  }

  // Test 3: Check if file closes after writing
  def testWriteFileClosing(): Unit = {
    val filePath = "testwrite.txt"
    val content = "Hello, world!"

    println("Testing file writing...")

    writeFile(filePath, content) match {
      case Right(_) =>
        println("File written successfully, checking if closed...")
        val isReadable = Try(Source.fromFile(filePath).getLines().mkString("\n")).isSuccess
        if (isReadable) println("File is readable after closing.")
        else println("File not readable after closing!")
      case Left(errorMessage) => println(s"File write failed: $errorMessage")
    }
  }

  // Test 4: Simulating error scenario (e.g., restricted file)
  def testWriteError(): Unit = {
    val invalidPath = "/restricted-folder/file.txt"

    println("Testing write error handling...")
    writeFile(invalidPath, "Data") match {
      case Right(_) => println("Unexpected success in restricted folder!")
      case Left(errorMessage) => println(s"Correctly handled write error: $errorMessage")
    }
  }

  def main(args: Array[String]): Unit = {
    testReadFileClosing()
    testMissingFileHandling()
    testWriteFileClosing()
    testWriteError()
  }

  // Reusing the original read and write functions
  def readFile(filePath: String): Either[String, String] = {
    Using(Source.fromFile(filePath)) { source =>
      source.getLines().mkString("\n")
    }.toEither.left.map(_ => "Error: Unable to read file!")
  }

  def writeFile(filePath: String, content: String): Either[String, String] = {
    Using(new PrintWriter(new File(filePath))) { writer =>
      writer.write(content)
      content
    }.toEither.left.map(_ => "Error: Unable to write to file!")
  }
}
