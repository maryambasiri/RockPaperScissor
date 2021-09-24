import java.io.IOException

import zio.clock.Clock
import zio.{ExitCode, IO, Task, UIO, URIO, ZIO}
import zio.console._
import zio.duration._
object ZioMain extends zio.App {


  override def run(args: List[String]): ZIO[Any, Nothing, ExitCode] = {
    //    ZioUI.play().catchAll(_ => putStrLn("There is an error"))
    //    .orDie
    //    .as(ExitCode.success)

    //--------------------------------
   val e: ZIO[Int, Throwable, Int] = for {
      env <- ZIO.environment[Int]
      _   <- Task{println(s"The value of the environment is: $env")}
    } yield env
  e.provide(1)
    .map(i => println(i))
    .orDie
    .as(ExitCode.success)

//-------------------------------------------

//    val square: ZIO[String with Int, Nothing, (String, Int)] =
//      for {
//        env <- ZIO.environment[Int]
//        input <- ZIO.environment[String]
//     //   _ <- putStrLn(s"The value of the environment is: $env")
//      } yield (input,env * env)
//println("Dfsdfsd")
//    val result: UIO[Int] = square.provide("123" with 42)
//    result
//      .map(r =>  println("hhhhhhhhhhhhhhh" + r.toString))
//    .as(ExitCode.success)

    //____________________________________________


//    val result: ZIO[Any with Clock, Nothing, String] = for {
//
//      fiber<-  IO.succeed("Hi!").race(IO.succeed("Bye!"))
//
//    } yield fiber
//
//    result.map { case (x) => println(s"$x") }.as(ExitCode.success)
 }
}
