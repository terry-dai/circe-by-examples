package examples

import io.circe.generic.auto._
import io.circe.syntax._
import io.circe.parser.decode
import models.Person

object AutoDerivation {
  def toJsonString(person: Person): String = {
    person.asJson.noSpaces
  }

  def parseJsonString(input: String): Either[Exception, Person] = {
    decode[Person](input)
  }
}
