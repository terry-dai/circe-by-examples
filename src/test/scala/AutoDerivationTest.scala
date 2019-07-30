import examples.AutoDerivation
import models.Person
import org.scalatest._

class AutoDerivationTest extends FunSpec with Matchers {

  describe("AutoDerivation") {

    describe("toJsonString") {

      it("should return json string represents a person") {
        assert(
          AutoDerivation
            .toJsonString(Person(name = "James")) == """{"name":"James"}"""
        )
      }

    }

    describe("parseJsonString") {

      it("should return a Person given a valid person json string") {
        assert(
          AutoDerivation.parseJsonString("""{"name":"James"}""") == Right(
            Person(name = "James"))
        )
      }

    }

  }
}
