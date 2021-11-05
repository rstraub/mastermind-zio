package kata

import zio.console.Console
import zio.{Has, ZIO}

object MastermindService {

  def evaluate(): ZIO[Has[CodeRepo] with Console with Has[Logger], Throwable, (Int, Int)] = for {
    codeRepo <- ZIO.service[CodeRepo]
    code <- codeRepo.getCode()
    _ <- ZIO.debug(code)
  } yield (0, 0)

}
