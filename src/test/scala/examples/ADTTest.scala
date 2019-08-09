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

      it("should return json string represents an Qux event") {
        assert(
          ADT.encodeJsonString(
            Qux(values = List("1", "2"))
          ) == """{"values":["1","2"]}"""
        )
      }

      it("should return json string represents an FooBar event") {
        assert(
          ADT.encodeJsonString(FooBar) == """"foobar""""
        )
      }

    }

    describe("should decodeJsonString") {

      it("should return Foo given a valid Foo json string") {
        assert(
          ADT.decodeJsonString("""{"i":1}""") == Right(Foo(i = 1))
        )
      }

      it("should return Bar given a valid Bar json string") {
        assert(
          ADT.decodeJsonString("""{"s":"1"}""") == Right(Bar(s = "1"))
        )
      }

      it("should return Qux given a valid Qux json string") {
        assert(
          ADT.encodeJsonString(
            Qux(values = List("1", "2"))
          ) == """{"values":["1","2"]}"""
        )
      }

      it("should return FooBar given a valid FooBar json string") {
        assert(
          ADT.decodeJsonString(""""foobar"""") == Right(FooBar)
        )
      }

    }

  }
}
