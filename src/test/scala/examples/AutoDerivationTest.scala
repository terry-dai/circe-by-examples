package examples

import models.Person
import org.scalatest._

class AutoDerivationTest extends FunSpec with Matchers {

  describe("AutoDerivation") {

    describe("encodeJsonString") {

      it("should return json string represents a person") {
        assert(
          AutoDerivation
            .encodeJsonString(Person(name = "James")) == """{"name":"James"}"""
        )
      }

    }

    describe("decodeJsonString") {

      it("should return a Person given a valid person json string") {
        assert(
          AutoDerivation.decodeJsonString("""{"name":"James"}""") == Right(
            Person(name = "James"))
        )
      }

    }

  }
}
