package ch7

object Task7_5 {
  def main(args: Array[String]) {

    def getProperty(s:String):Option[String]={
    util.Try (System.getProperty(s)) match {
      case util.Success(x)=>Option(x)
      case util.Failure(ex)=> None
    }
    }

    println(getProperty("os.arch"))

    println(getProperty("blarg"))
  }

}
