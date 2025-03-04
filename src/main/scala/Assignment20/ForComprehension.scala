package Assignment20

//for comprehension is used to clean and make code readable
object ForComprehension {
  val age: Option[Int]=Some(25)
  val salary: Option[Double]=Some(50000)
  val bonus: Option[Double]=Some(5000)

 def main(args:Array[String]):Unit={
   val totalSalary : Option[Double] = for {
     s <- salary
     b <- bonus
   } yield s+b
   println(totalSalary)
   }
 }