package com.epsi.atomicdata.atomicData

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router

class LabelsHandler: AbstractVerticle() {
  override fun start(startFuture: Future<Void>) {
    Router.router(vertx).route(HttpMethod.GET, "/labels").handler { routingContext ->
      Router.router(vertx).get("https://4ab8d5a1-a9f4-4482-8871-1b218ebef825.mock.pstmn.io/labels")
      routingContext.response().putHeader("content-type", "application/json").end()
    }
  }
}
