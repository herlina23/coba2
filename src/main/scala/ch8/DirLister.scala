package ch8

import java.io.{FilenameFilter, File}


class DirLister(path: String, f: String => Boolean) {

  lazy val file: File = new File(path)

  lazy val filter = new FilenameFilter {
    override def accept(dir: File, name: String): Boolean = f(name)
  }

  def list: List[String] = file.list(filter).toList

}

//object DirLister {
//
//   def main(args: Array[String]) {
//    println("test")
//  }
//
//}