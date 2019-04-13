import controllers.TestController
import io.vertx.core.VertxOptions
import io.vertx.kotlin.micrometer.vertxJmxMetricsOptionsOf
import io.vertx.rxjava.core.Vertx

fun main(args: Array<String>) {
    Server()
}


/**
 * Class contains server's starts logic
 * @author kostya05983
 */
class Server {

    init {
        deployVerticles()
    }

    /**
     * Init logging with this fun
     */
    private fun initLogging() {

    }

    /**
     * fun used to deploy vertx's verticles
     */
    private fun deployVerticles() {
        val options = VertxOptions()
        Vertx.rxClusteredVertx(options).subscribe({
            it.deployVerticle(TestController())
        },{

        })
    }
}