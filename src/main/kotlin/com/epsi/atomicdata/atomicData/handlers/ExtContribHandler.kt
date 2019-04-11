package com.epsi.atomicdata.atomicData

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router

class ExtContribHandler: AbstractVerticle() {
  override fun start(startFuture: Future<Void>) {
    Router.router(vertx).route(HttpMethod.GET, "/extcontrib").handler { routingContext ->
      routingContext.response().putHeader("content-type", "application/json").end()
    }
  }
}
