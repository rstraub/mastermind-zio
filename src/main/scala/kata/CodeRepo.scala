package kata

import zio._
import zio.console.{Console, putStr}

import java.io.IOException

class CodeRepo {

  def getCode(): ZIO[Has[Logger] with Console, IOException, List[String]] = for {
    logger <- ZIO.service[Logger]
    _ <- logger.log("Code requested")
  } yield List("blue", "yellow", "green", "red")

}

class Logger {

  def log(string: String): ZIO[Console, IOException, Unit] = putStr(string)
}
