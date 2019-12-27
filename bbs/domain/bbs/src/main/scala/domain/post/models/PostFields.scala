package domain.post.models

import java.util.Date

import models.Fields

trait PostFields  extends Fields{
  val identifier: PostId
  val title: String
  val content: String
  val createdDate: Date
}
