package Assignment23

import scala.util.Using
import scala.io.Source

object FileReader {
  def main(args:Array[String]): Unit={
    val filePath="example.txt"

    val fileContent = Using(Source.fromFile(filePath)) { source =>
      source.getLines().mkString("\n") // Reads entire file and joins lines
    }

    fileContent match {
      case scala.util.Success(content) => println("File Content:\n" + content)
      case scala.util.Failure(exception) => println("Error reading file: " + exception.getMessage)
    }


  }
  }

