package format

import fr.loicknuchel.typedapi.errors.OpenApiError
import model._

// pattern typeclass
object Implicits {

  implicit val openApiErrorPrinter = new Format[OpenApiError] {
    override def format: OpenApiError => String = { error =>
      val indent = "  - "
      s"""
           |at ${error.path.mkString}
           |$indent${error.errors.map(_.format).toList.mkString(indent)}
        """.stripMargin
    }
  }

  implicit val validationOutputFormat = new Format[ValidationOutput] {
    def format: ValidationOutput => String = {
      case Right(value) => "true"
      case Left(value) =>
        value match {
          case ProgramArgumentNotFound(_) =>
            """
                |   Program argument not found.
                |   You need to write the name of the file to validate.
          """.stripMargin
          case FileNotFound(_) =>
            "File not found"
          case CannotParseJson(m) =>
            s"""
                 |  Cannot parse JSON ${m.getMessage}
          """.stripMargin
          case ValidationError(m) =>
            m.toList
              .map(
                openApiErrorPrinter.format
              )
              .mkString("\n")
        }
    }
  }

}
