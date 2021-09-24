import java.io.IOException

import zio.{ExitCode, ZIO}
import zio.console.{Console, putStrLn}

val e: ZIO[Console with Int, IOException, Int] = for {
  env <- ZIO.environment[Int]
  _   <- putStrLn(s"The value of the environment is: $env")
} yield env
e.map(i => println(i)).as(ExitCode.success)

val square: URIO[Int, Int] =
  for {
    env <- ZIO.environment[Int]
  } yield env * env

val result: UIO[Int] = square.provide(42)