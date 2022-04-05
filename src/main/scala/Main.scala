import scala.util.Try
import fr.loicknuchel.typedapi.OpenApiFactory.{parseJson => jsonToOpenApi}
import play.api.libs.json.Json.{parse => textToJson}
import fr.loicknuchel.typedapi.errors.OpenApiErrors
import fr.loicknuchel.typedapi.models.OpenApi

import scala.io.Source.fromFile
import Implicits._
import format.ValidationOutputFormat
import model._

object Main extends App {
  def validate: ValidationOutput =
    for {
      filename <- Try(args.apply(0)) or ProgramArgumentNotFound
      text <- Try(fromFile(filename).getLines.mkString) or FileNotFound
      json <- Try(textToJson(text)) or CannotParseJson
      openapi <- jsonToOpenApi(json) or ValidationError
    } yield openapi

  println("Welcome to the Scala OpenAPI validator")

  val validated = validate

  println(
    ValidationOutputFormat.format(validated)
  )

  validated match {
    case Left(_)  => sys.exit(1)
    case Right(_) => sys.exit(0)
  }

}
