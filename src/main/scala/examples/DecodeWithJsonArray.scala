package examples

import examples.People.People
import io.circe.Decoder
import io.circe.generic.auto._
import io.circe.parser.decode
import models.Person

object People {
  type People = Vector[Person]

//  val peopleDecoder: Decoder[People] = (c: HCursor) =>
//    c.downField("people").as[People]

  val peopleDecoder: Decoder[People] = Decoder[People].prepare(
    _.downField("people")
  )
}

object DecodeWithJsonArray {
  implicit val decoder = People.peopleDecoder

  def decodeJsonString(input: String): Either[Exception, People] = {
    decode[People](input)
  }
}
