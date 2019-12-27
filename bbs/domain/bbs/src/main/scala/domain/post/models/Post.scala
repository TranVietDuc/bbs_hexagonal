package domain.post.models

import java.util.Date

import models.Entity

trait Post extends Entity[PostId] with PostFields {
}

object Post {
  def apply(identifier: PostId, title: String, content: String, createdDate: Date): Post = PostImpl(identifier,title,content,createdDate)
}