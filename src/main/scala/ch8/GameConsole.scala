package ch8

import java.util.Date


abstract class MediaFormat
class DvdMediaFormat extends MediaFormat
class BluRayMediaFormat extends MediaFormat
class USBMediaFormat extends MediaFormat
class CartridgeMediaFormat extends MediaFormat

abstract class VideoResolution(pixels: Int)
class HD extends VideoResolution(1280 * 720)
class FHD extends VideoResolution(1920 * 1080)
class QHD extends VideoResolution(2560 * 1440)
class UHD4K extends VideoResolution(3840 * 2160)


/**
  * A console that can play games built for it with one or more video resolutions.
  */
class GameConsole(val make: String, val model: String, val debut: Date, val wifiType: Option[String],
                  val mediaFormats: List[MediaFormat], val maxVideoResolution: VideoResolution) {

  override def toString = s"GameConsole($make, $model), max video resolution = ${maxVideoResolution.getClass.getName}"
}



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


/**
  * A game developed for one or more game consoles
  */
class Game(val name: String, val maker: String, val consoles: List[GameConsole]) {
  def isSupported(console: GameConsole) = consoles contains console
  override def toString = s"Game($name, by $maker)"
}

class GameShop {

  val consoles = new GameConsoleLibrary()

  val games = List(
    new Game("Elevator Action", "Taito", List(consoles.chanduOne)),
    new Game("Mappy", "Namco", List(consoles.chanduOne, consoles.aquaTopia)),
    new Game("StreetFigher", "Capcom", List(consoles.oonaSeven, consoles.leoChallenge))
  )

  val consoleToGames: Map[GameConsole, List[Game]] = {
    val consoleToGames1: List[(GameConsole, Game)] = games flatMap (g => g.consoles.map(c => c -> g))
    val consoleToGames2: Map[GameConsole, List[(GameConsole, Game)]] = consoleToGames1 groupBy (_._1)
    val consoleToGames3: Map[GameConsole, List[Game]] = consoleToGames2 mapValues(_ map (_._2))
    consoleToGames3
  }

  def reportGames(): Unit = {
    games sortBy (g => s"${g.maker}_${g.name}") foreach { game =>
      val consoleInfo = game.consoles.map(c => s"${c.make} ${c.model}").mkString(", ")
      println(s"${game.name} by ${game.maker} for $consoleInfo")
    }
  }

}