package kata

import zio.ZIO.debug
import zio._
import zio.console.Console

object Kata extends zio.App {

  /*

      a repo to retrieve the code we need to crack

      inject the repo in a service??
  */

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] = {


    val codeRepo = new CodeRepo()
    val codeRepoLayer: ZLayer[Any, Nothing, Has[CodeRepo]] = ZLayer.succeed(codeRepo)
    val loggerLayer = ZLayer.succeed(new Logger())
    val combinedLayer = loggerLayer ++ codeRepoLayer ++ Console.live

    val evaluate: ZIO[Has[CodeRepo] with Console with Has[Logger], Throwable, (Int, Int)] = MastermindService.evaluate()
    val provided = evaluate.provideLayer(combinedLayer)
    val nonFailable: ZIO[Any, Nothing, Any] = provided.catchAll(err => ZIO.debug(err))

    val exitCode: URIO[Console, ExitCode] = nonFailable.exitCode

    exitCode

  }
}
