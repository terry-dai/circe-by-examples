package examples

import models.Person
import org.scalatest.FunSpec

class DecodeWithJsonArrayTest extends FunSpec {

  describe("DecodeWithJsonArray") {

    describe("testDecodeJsonString") {

      it("should return People given a valid json string") {
        assert(
          DecodeWithJsonArray.decodeJsonString(
            """
              |{
              |  "people": [
              |    {"name":"James"},
              |    {"name":"Dr.No"}
              |  ]
              |}
            """.stripMargin
          ) == Right(
            Vector(
              Person(name = "James"),
              Person(name = "Dr.No")
            )
          )
        )

      }

    }
  }

}
