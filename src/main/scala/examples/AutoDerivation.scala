package examples

import io.circe.generic.auto._
import io.circe.syntax._
import io.circe.parser.decode
import models.Person

object AutoDerivation {

  def encodeJsonString(person: Person): String = {
    person.asJson.noSpaces
  }

  def decodeJsonString(input: String): Either[Exception, Person] = {
    decode[Person](input)
  }

}
