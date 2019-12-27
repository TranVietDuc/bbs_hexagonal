package domain.user.models

import models.Fields

trait UserFields extends Fields {
  val identifier: UserId
  val email: String
  val password: String
  val userName: String

}
