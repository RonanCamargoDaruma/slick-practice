package ronancamargo

import cats.effect.IO
import cats.effect.unsafe.implicits.global

import scala.concurrent.Future

object Util {
  def awaitFuture[A](future: => Future[A]): A = IO.fromFuture(IO(future)).unsafeRunSync()

  def awaitAndPrintResult[A](future: => Future[A]): Unit = awaitFuture(future).printResult()

  implicit class Printer[A](print: A) {
    def printResult(): Unit = println(print.toString)
  }
}
