package com.epsi.atomicdata.atomicData

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router

class MainVerticle : AbstractVerticle() {

  override fun start(startFuture: Future<Void>) {
    var server = vertx.createHttpServer()
    var router = Router.router(vertx)

    router.route(HttpMethod.POST, "/oauth").handler { routingContext ->
      router.post("https://4ab8d5a1-a9f4-4482-8871-1b218ebef825.mock.pstmn.io/oauth")
      routingContext.response().putHeader("content-type", "application/json").end()
    }

    router.route(HttpMethod.GET, "/languages").handler { routingContext ->
      router.get("https://4ab8d5a1-a9f4-4482-8871-1b218ebef825.mock.pstmn.io/languages")
      routingContext.response().putHeader("content-type", "application/json").end()
    }

    router.route(HttpMethod.GET, "/labels").handler { routingContext ->
      router.get("https://4ab8d5a1-a9f4-4482-8871-1b218ebef825.mock.pstmn.io/labels")
      routingContext.response().putHeader("content-type", "application/json").end()
    }

    router.route(HttpMethod.GET, "/contributors").handler { routingContext ->
      routingContext.response().putHeader("content-type", "application/json").end()
    }

    router.route(HttpMethod.GET, "/pullrequests").handler { routingContext ->
      routingContext.response().putHeader("content-type", "application/json").end()
    }

    router.route(HttpMethod.GET, "/issues").handler { routingContext ->
      routingContext.response().putHeader("content-type", "application/json").end()
    }

    router.route(HttpMethod.GET, "/repositories").handler { routingContext ->
      routingContext.response().putHeader("content-type", "application/json").end()
    }

    router.route(HttpMethod.GET, "/misc").handler { routingContext ->
      routingContext.response().putHeader("content-type", "application/json").end()
    }

    router.route(HttpMethod.GET, "/extcontrib").handler { routingContext ->
      routingContext.response().putHeader("content-type", "application/json").end()
    }

    router.route(HttpMethod.GET, "/dependencies").handler { routingContext ->
      routingContext.response().putHeader("content-type", "application/json").end()
    }

    server.requestHandler(router).listen(8080)
  }
}
