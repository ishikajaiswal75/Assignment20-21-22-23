package Assignment20

object OptionTransform {
  def getTranformUsinMap(num: Option[Int] ) : Option[Int]={
    num.map(_*2)
  }
  def getTransformUsinFlatMap(num: Option[Int]) : Option[Int]={
    num.flatMap(x=>Some(x*2))
  }
  def main(args: Array[String]):Unit={
    val num1:Option[Int]=Some(10)
    val num2:Option[Int]=None


    println(getTranformUsinMap(num1))
    println(getTransformUsinFlatMap(num2))


    println(getTransformUsinFlatMap(num1))
    println(getTransformUsinFlatMap(num2))


    //here it will show nesting option like Some inside Some (so to avod this we use flatMap)
    val num3: Option[Option[Int]] = num1.map(x => Some(x * 2))
    println(num3)

  }

}
