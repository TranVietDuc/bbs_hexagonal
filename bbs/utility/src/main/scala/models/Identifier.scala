package models

trait Identifier[+A] extends Serializable {
  def value: A
}
