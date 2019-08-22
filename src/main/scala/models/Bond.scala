package models

import io.circe.Encoder
import io.circe.syntax._

case class Bond(i: Int) {
  val title: String = "No Time To Die"
}

object Bond {

  // Bond encoder
  // Simpler implementation
  //  implicit val encoderbond: encoder[bond] =
  //    Encoder.forProduct2[Int, String, Bond]("i", "title")(b => (b.i, b.title))

  // Transform encoder and add missing fields.
  import io.circe.generic.semiauto.deriveEncoder
  implicit val encoderBond: Encoder[Bond] = Encoder.instance(
    b =>
      deriveEncoder[Bond]
        .apply(b)
        .mapObject(jo => jo.add("title", b.title.asJson))
  )
}
