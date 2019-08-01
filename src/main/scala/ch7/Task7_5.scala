package ch7

object Task7_5 {

  //System methods for reading system properties and environment variables.
  def main(args: Array[String]) {

    def getProperty(s:String):Option[String]={
    util.Try (System.getProperty(s)) match {
      case util.Success(x)=>Option(x)
      case util.Failure(ex)=> None
    }
    }

    // option : As a collection whose size will never be larger than one, the Option type represents the
    //presence or absence of a single value. This potentially missing value (e.g., it was never
    //initialized, or could not be calculated) can thus be wrapped in an Option collection and
    //have its potential absence clearly advertised.

    // try : The util.Try collection turns error handling into collection management. It provides
    //a mechanism to catch errors that occur in a given function parameter, returning either
    //the error or the result of the function if successful.

    // future : a future represents a potential value and provides
    //safe operations to either chain additional operations or to extract the value

    // gimana caranya hasilnya ga null
    // gimana caranya dr getProperty ini tau isinya ada ato ngga!
    // option ,try

      // spy throw error ga ngebreak aplikasi, jadi manajemen error hanyalah seperti membuat monadic collection
    // dimana, kalau suatu code sukses akan men-deliver nilainya dan kalau fail akan memberikan value exception
    println(getProperty("os.arch")) // hslnya (amd64) karena os.arch adalah default property dari sistem
    println(getProperty("blarg")) // hasilnya adalah None karena masuk exception, karena string tsb bukankan  default property dari  system
    println(getProperty("wiwiwiwi"))// hasilnya adalah None karena masuk exception, karena string tsb bukankan  default property dari  system
    println(getProperty("java.home"))// hslnya (Some(C:\Program Files\Java\jdk1.8.0_131\jre)) karena java.home adalah default property dari sistem
    println(getProperty(""))// hasilnya adalah None karena masuk exception, karena string tsb bukankan  default property dari  system

  }

}
