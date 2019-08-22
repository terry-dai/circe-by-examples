package examples

import models._
import io.circe.syntax._
import org.scalatest.FunSpec

class SpecialCaseClassTest extends FunSpec {

  describe("ADTTest") {

    describe("encodeJsonString") {

      it("should return json string represents an Bond event") {
        assert(
          Bond(i = 25).asJson.noSpaces == """{"i":25,"title":"No Time To Die"}"""
        )
      }

    }

  }

}
