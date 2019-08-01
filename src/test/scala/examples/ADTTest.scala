package examples

import models._
import org.scalatest.FunSpec

class ADTTest extends FunSpec {

  describe("ADTTest") {

    describe("encodeJsonString") {

      it("should return json string represents an Foo event") {
        assert(
          ADT.encodeJsonString(Foo(i = 1)) == """{"i":1}"""
        )
      }

      it("should return json string represents an Bar event") {
        assert(
          ADT.encodeJsonString(Bar(s = "1")) == """{"s":"1"}"""
        )
      }

    }

    describe("should decodeJsonString") {

      it("should return Foo given a valid json string") {
        assert(
          ADT.decodeJsonString("""{"i":1}""") == Right(Foo(i = 1))
        )
      }

      it("should return Bar given a valid json string") {
        assert(
          ADT.decodeJsonString("""{"s":"1"}""") == Right(Bar(s = "1"))
        )
      }

    }

  }
}
