import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes.OK
import akka.http.scaladsl.server.Directives.{complete, path, post}
import akka.http.scaladsl.server.Route
import spray.json.RootJsonFormat
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._

import scala.concurrent.ExecutionContext.Implicits.global

object Main {

  import JsonImplicits._

  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("DummyServer")
    val route: Route = path("my-redirect") {
      post {
        println("Received request")
        complete(OK, PaymentResponse("https://www.my-very-custom-redirect-url/it-works"))
      }
    }

    val server = Http().newServerAt("localhost", 9090).bind(route)
    server.map { _ =>
      println("Successfully started on localhost:9090")
    } recover {
      case ex =>
        println("Failed to start the server due to: " + ex.getMessage)
    }
  }
}

case class PaymentResponse(redirectUrl: String)

object JsonImplicits {

  import spray.json.DefaultJsonProtocol._

  implicit val PaymentResponseFormat: RootJsonFormat[PaymentResponse] = jsonFormat1(PaymentResponse)
}