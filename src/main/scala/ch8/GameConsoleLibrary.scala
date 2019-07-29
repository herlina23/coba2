package ch8

import java.util.Date

class GameConsoleLibrary {

  def strToDate(s: String): Date = java.text.DateFormat.getInstance.parse(s)

  val chanduOne = new GameConsole("Chandu", "One", strToDate("2/12/2007 0:00 AM"), Some("a/b"),
    List(new CartridgeMediaFormat), new HD)

  val aquaTopia = new GameConsole("Aqua", "Topia", strToDate("5/2/2012 0:00 AM"), Some("a/b/g"),
    List(new DvdMediaFormat), new HD)

  val oonaSeven = new GameConsole("Oona", "Seven", strToDate("3/3/2014 0:00 AM"), Some("b/g/n"),
    List(new BluRayMediaFormat, new DvdMediaFormat), new FHD)

  val leoChallenge = new GameConsole("Leonardo", "Challenge", strToDate("12/12/2014 0:00 AM"), Some("g/n"),
    List(new USBMediaFormat), new UHD4K)

}