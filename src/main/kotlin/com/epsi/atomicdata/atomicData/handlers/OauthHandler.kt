package com.epsi.atomicdata.atomicData

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router
import io.vertx.ext.web.client.WebClient

class OauthHandler: AbstractVerticle() {
  override fun start(startFuture: Future<Void>) {
    Router.router(vertx).route(HttpMethod.POST, "/oauth").handler { routingContext ->
      WebClient.create(vertx).get("http://4ab8d5a1-a9f4-4482-8871-1b218ebef825.mock.pstmn.io/oauth").send { ar ->
        if (ar.succeeded()) {
          routingContext.response()
            .setChunked(true)
            .putHeader("content-type", "application/json")
            .write(ar.result().bodyAsJsonObject().encode())
            .end()
        }
      }
    }
  }
}
