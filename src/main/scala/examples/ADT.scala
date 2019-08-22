package examples

import io.circe.parser.decode
import io.circe.syntax._
import models.Event
import models.Event._

object ADT {

  def encodeJsonString(person: Event): String = {
    person.asJson.noSpaces
  }

  def decodeJsonString(input: String): Either[Exception, Event] = {
    decode[Event](input)
  }

}
