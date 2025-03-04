package Assignment20

object CollectionIndex {
  def getElement[T](collection:Seq[T],index: Int): Option[T]={
    if(index>0 && index < collection.length) Some(collection(index))
    else None
  }
  def main(args:Array[String]):Unit={
    val numbers=List(10,20,30,40)
    val words=List("One","Two","Three","Four")

    println((getElement(numbers,2)))
    println((getElement(numbers,5)))

    println(getElement(words,2))
    println(getElement(words,-1))
  }
}
