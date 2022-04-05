import fr.loicknuchel.typedapi.errors.OpenApiErrors
import fr.loicknuchel.typedapi.models.OpenApi

package object model {

  sealed trait Errors
  case class ProgramArgumentNotFound(m: Throwable) extends Errors
  case class FileNotFound(m: Throwable) extends Errors
  case class CannotParseJson(m: Throwable) extends Errors
  case class ValidationError(m: OpenApiErrors) extends Errors

  type ValidationOutput = Either[Errors, OpenApi]

}
