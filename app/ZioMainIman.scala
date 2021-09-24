import zio.{ExitCode, Task, UIO, URIO, ZIO}
import zio.console._

object ZioMainIman extends zio.App{
  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = {

    (for{
      result <- myApp()
      _ <- putStrLn(s"this is my result $result")
    }yield ())
      .catchAllCause(e => putStrLn(s"there is an exception"))
       .orDie
       .as(ExitCode.success)
  }

  def myApp(): ZIO[Console, Throwable, Int] = {
    val f1 = Task{
      println(Thread.currentThread().getName)
      Integer.parseInt("1")
    }
   for{
      _ <- putStr("Enter first number:")
      x1 <- getStrLn
      x1Num <- f1.fork
      _ <- putStr("Enter second number:")
      x2 <- getStrLn
      x2Num <- Task{
        println(Thread.currentThread().getName)
        Integer.parseInt(x2)
      }.fork
     x11 <- x1Num.zipWith(x2Num)(_ + _).join
    }yield x11
  }
}
