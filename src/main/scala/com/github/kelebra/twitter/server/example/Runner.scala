package com.github.kelebra.twitter.server.example

import com.github.kelebra.twitter.server.example.service.HelloService
import com.twitter.finagle.http.HttpMuxer
import com.twitter.server.TwitterServer
import com.twitter.util.Await

object Runner extends TwitterServer {

  private val counter = statsReceiver.counter("requests_counter")

  override def failfastOnFlagsNotParsed: Boolean = true

  def main() {
    val service = HelloService(counter, logger)
    HttpMuxer.addHandler("/echo", service)
    HttpMuxer.addHandler("/echo/", service)
    // And wait on the server
    Await.ready(adminHttpServer)
  }
}
