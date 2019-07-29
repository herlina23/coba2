package ch8

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
    val consoleToGames3: Map[GameConsole, List[(GameConsole, Game)]] = consoleToGames2 mapValues(_ map (_._2))
    //val consoleToGames3: Map[GameConsole, List[Game]] = consoleToGames2 mapValues(_ map (_._2))
    consoleToGames3
  }

  def reportGames(): Unit = {
    games sortBy (g => s"${g.maker}_${g.name}") foreach { game =>
      val consoleInfo = game.consoles.map(c => s"${c.make} ${c.model}").mkString(", ")
      println(s"${game.name} by ${game.maker} for $consoleInfo")
    }
  }

}