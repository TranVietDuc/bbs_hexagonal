package domain.post.models

import models.Identifier

case class PostId(value: String) extends Identifier[String]
