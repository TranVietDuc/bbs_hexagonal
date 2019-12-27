package domain.user

import domain.user.models.User

import scala.util.Try

trait UserRepository {
  def findAll(): Try[Seq[User]]

  def insert(user: User): Try[Long]
}
