package domain.user.models

import models.Entity

trait User extends Entity[UserId] with UserFields {}

object User {
  def apply(identifier: UserId, email: String, password: String, userName: String): User = UserImpl(identifier, email, password, userName)
}




