package domain.post.models

import java.util.Date

private[post] case class PostImpl(identifier: PostId, title: String, content: String, createdDate: Date) extends Post
