package net.pb.search

import java.net.InetAddress

import org.elasticsearch.client.Client
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.InetSocketTransportAddress

object ElasticSearchManager {

  private val port = 9300

  private val nodes = List("localhost")

  private val addresses = nodes.map { host => new InetSocketTransportAddress(InetAddress.getByName(host), port) }

  lazy private val settings = Settings.builder()
    .put("cluster.name", "elasticsearch")
    .build()

  val client:Client = TransportClient.builder()
    .settings(settings).build().addTransportAddresses(addresses:_*)

}
