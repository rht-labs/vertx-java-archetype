#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import spock.lang.Specification
import spock.util.concurrent.AsyncConditions
import io.vertx.core.Vertx
import io.vertx.core.DeploymentOptions

class MainSpec extends Specification {

    def "Test deployment of Main Verticle"() {
        given: "An instance of the Vertx singleton"
            def vertx = Vertx.vertx()
            def async = new AsyncConditions(1)

        when: "We attempt to deploy that Verticle"
            vertx.deployVerticle(new Main(), new DeploymentOptions(), { res ->
                async.evaluate {
                    res.succeeded() == true
                }
            })

        then: "We expect the Verticle to deploy successfully"
            async.await(5)
            vertx.close()
    }
}