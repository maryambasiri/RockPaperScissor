import java.io.IOException

import zio.clock.Clock
import zio.{ExitCode, IO, Task, UIO, URIO, ZIO}
import zio.console._
import zio.duration._

object ZioMain extends zio.App {

  override def run(args: List[String]): ZIO[Any, Nothing, ExitCode] = {

    val e: ZIO[Int, Throwable, Int] = for {
      env <- ZIO.environment[Int]
      _ <- Task {
        println(s"The value of the environment is: $env")
      }
    } yield env
    e.provide(1)
      .map(i => println(i))
      .orDie
      .as(ExitCode.success)


  }
}
