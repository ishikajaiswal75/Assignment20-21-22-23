package Assignment20

object ValidationTest {
  def main(args: Array[String]): Unit = {
    testGetElement()
    testOptionTransform()
    testForComprehension()

    println("All tests passed successfully!")
  }

  def testGetElement(): Unit={
    val numbers=List(10,20,30,40)
    val words=List("One","Two","Three")

    //when value is present
    assert(CollectionIndex.getElement(numbers,2)==Some(30), "Test failed: Expected Some(30)")
    assert(CollectionIndex.getElement(words,2)==Some("Three"),"Test failed: Exception Some('Three')")

    // When value is absent
    assert(CollectionIndex.getElement(numbers, 5) == None, "Test failed: Expected None")
    assert(CollectionIndex.getElement(words, -1) == None, "Test failed: Expected None")

    println("getElement function tests passed!")
  }

//option transform testing
  def testOptionTransform(): Unit = {
    val num1: Option[Int] = Some(10)
    val num2: Option[Int] = None

    // Using map
    assert(OptionTransform.getTranformUsinMap(num1) == Some(20), "Test failed: Expected Some(20)")
    assert(OptionTransform.getTranformUsinMap(num2) == None, "Test failed: Expected None")

    // Using flatMap
    assert(OptionTransform.getTransformUsinFlatMap(num1) == Some(20), "Test failed: Expected Some(20)")
    assert(OptionTransform.getTransformUsinFlatMap(num2) == None, "Test failed: Expected None")

    // Checking nested Option case
    val num3: Option[Option[Int]] = num1.map(x => Some(x * 2))
    assert(num3 == Some(Some(20)), "Test failed: Expected Some(Some(20))")

    println("OptionTransform function tests passed!")
  }

//for comprehension test
  def testForComprehension(): Unit = {
    val salary: Option[Double] = Some(50000)
    val bonus: Option[Double] = Some(5000)
    val missingSalary: Option[Double] = None
    val missingBonus: Option[Double] = None

    val totalSalary = for {
      s <- salary
      b <- bonus
    } yield s + b

    assert(totalSalary == Some(55000.0), "Test failed: Expected Some(55000.0)")

    // When salary is None
    val totalSalaryNone1 = for {
      s <- missingSalary
      b <- bonus
    } yield s + b
    assert(totalSalaryNone1 == None, "Test failed: Expected None")

    // When bonus is None
    val totalSalaryNone2 = for {
      s <- salary
      b <- missingBonus
    } yield s + b
    assert(totalSalaryNone2 == None, "Test failed: Expected None")

    println("ForComprehension function tests passed!")
  }
}


