package ronancamargo.entities

sealed abstract class IdentificationType(val description: String)

object IdentificationType {
  case object DNI extends IdentificationType("DNI")
  case object LC  extends IdentificationType("LC")
  case object CI  extends IdentificationType("CI")

  def fromDescription(desc: String): IdentificationType = desc match {
    case "DNI" => DNI
    case "LC"  => LC
    case "CI"  => CI
  }
}
