package com.epsi.atomicdata.atomicData

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router

class MiscHandler: AbstractVerticle() {
  override fun start(startFuture: Future<Void>) {
    Router.router(vertx).route(HttpMethod.GET, "/misc").handler { routingContext ->
      routingContext.response().putHeader("content-type", "application/json").end()
    }
  }
}
