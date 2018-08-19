package com.github.kelebra.twitter.server.example.service

import com.twitter.finagle.Service
import com.twitter.finagle.http.{Request, Response, Status}
import com.twitter.finagle.stats.Counter
import com.twitter.util.logging.Logger
import com.twitter.util.{Future, Time}

class HelloService(requestCounter: Counter, logger: Logger)
  extends Service[Request, Response] {

  override def apply(request: Request): Future[Response] = {
    logger.info("Received a request at " + Time.now)
    requestCounter.incr()
    val response = Response(request.version, Status.Ok)
    response.contentString = "hello" + "\n"
    Future.value(response)
  }
}

object HelloService {

  def apply(requestCounter: Counter, logger: Logger): HelloService =
    new HelloService(requestCounter, logger)
}