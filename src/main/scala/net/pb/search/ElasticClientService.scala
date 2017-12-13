package net.pb.search

import org.elasticsearch.action.bulk.BulkRequestBuilder
import org.elasticsearch.action.index.IndexResponse
import org.elasticsearch.client.Client
import org.elasticsearch.index.query.QueryBuilders

import scala.io.Source

trait ElasticClientServiceApi {
  val client: Client = ElasticSearchManager.client

  def addFromTextFile(source:String):Unit = {
    val fileData = Source.fromFile(source).getLines().toList

    val bulkData: BulkRequestBuilder = client.prepareBulk()

    fileData.foreach {
      json => bulkData.add(client.prepareIndex("library", "dataset").setSource(json))
    }
    bulkData.execute().actionGet()
  }

  def search(query: String, value: String):Unit = {
    client.admin().indices().prepareRefresh("library").get()
    client.prepareSearch("library").setTypes("dataset")
      .setQuery(QueryBuilders.termQuery(s"$query", s"$value")).execute().actionGet()
  }

  def add(srcname: String, content: String, id: String): IndexResponse = {
    val jsonString =
      s"""
         |{
         |  "document_name": "$srcname",
         |  "content": "$content"
         |}
       """.stripMargin

    client.prepareIndex("library", "dataset", id).setSource(jsonString).get()
  }
}

class ElasticClientService extends ElasticClientServiceApi
