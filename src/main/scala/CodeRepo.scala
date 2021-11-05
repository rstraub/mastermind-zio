object CodeRepo {

  def getCode(): ZIO[Any, Nothing, List[String]] = {

    ZIO.succeed("blue", "yellow", "green", "red")
  }

}
