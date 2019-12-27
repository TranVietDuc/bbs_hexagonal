package models

trait  Entity[ID <: Identifier[_]] {
  val identifier: ID
}
