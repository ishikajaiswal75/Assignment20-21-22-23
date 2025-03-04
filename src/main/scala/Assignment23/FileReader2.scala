package Assignment23

import scala.util.{Try,Success,Failure}
import scala.io.Source
object FileReader2 {


  def readFile(filePath: String): Either[String, Option[String]] = {
    Try {
      val source = Source.fromFile(filePath)
      try Some(source.getLines().mkString("\n"))
      finally source.close()
    }
      .recover {
        case _: java.io.FileNotFoundException => None // Fallback: Return None for missing file
        case _: Exception => Some(" Error: Unable to read file!") // Fallback: Return error message
      } match {
      case Success(content) => Right(content)
      case Failure(_) => Left("Unknown error occurred!")
    }
  }
  def main(args: Array[String]): Unit = {
    val filePath = "example.txt"

    readFile(filePath) match {
      case Right(Some(content)) => println("📄 File Content:\n" + content)
      case Right(None) => println(" File not found")
      case Left(errorMessage) => println(errorMessage)
    }
  }
}