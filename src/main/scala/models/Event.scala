package models

import io.circe._
import io.circe.generic.auto._
import io.circe.syntax._
import cats.syntax.functor._

sealed trait Event

case class Foo(i: Int) extends Event
case class Bar(s: String) extends Event
case class Qux(values: List[String]) extends Event

case object FooBar extends Event

object Event {

  implicit val encodeEvent: Encoder[Event] = Encoder.instance {
    case foo @ Foo(_) => foo.asJson
    case bar @ Bar(_) => bar.asJson
    case qux @ Qux(_) => qux.asJson
    case FooBar       => "foobar".asJson
  }

  val decodeFooBar: Decoder[Event] = Decoder.decodeString.emap(
    value =>
      value match {
        case "foobar" => Right(FooBar)
        case _        => Left("Invalid FooBar value.")
    }
  )

  implicit val decodeEvent: Decoder[Event] =
    List[Decoder[Event]](
      Decoder[Foo].widen,
      Decoder[Bar].widen,
      Decoder[Qux].widen,
      decodeFooBar
    ).reduceLeft(_ or _)

}
