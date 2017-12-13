package net.pb.search

import org.elasticsearch.action.bulk.BulkRequestBuilder
import org.elasticsearch.client.Client

import scala.io.Source

trait elasticClientServiceApi {
  val client: Client = ElasticSearchManager.client

  def addFromTextFile(source:String):Unit = {
    val fileData = Source.fromFile(source).getLines().toList

    val bulkData: BulkRequestBuilder = client.prepareBulk()

    fileData.foreach {
      json => bulkData.add(client.prepareIndex("library", "dataset").setSource(json))
    }
    bulkData.execute().actionGet()
  }



}

class elasticClientService extends elasticClientServiceApi
