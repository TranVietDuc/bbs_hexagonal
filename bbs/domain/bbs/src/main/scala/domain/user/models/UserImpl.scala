package domain.user.models

private[user] case class UserImpl(identifier: UserId, email: String, password: String, userName: String) extends User
