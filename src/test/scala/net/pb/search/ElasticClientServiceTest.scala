package net.pb.search

import org.scalatest.{FunSuite, Matchers}

class ElasticClientServiceTest extends FunSuite with Matchers {

  test("add a new item to the index") {
    val ecs = new ElasticClientService()

    ecs.add("file1.txt", "The little brown fox jumps over the red gate", "123") shouldBe IndexedSeq
  }

  test("add a bulk collection of items to the search index") {

  }

  test("update an existing item in the search index") {

  }

  test("remove an item from the search index") {

  }
}