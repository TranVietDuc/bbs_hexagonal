package domain.post

import domain.post.models.Post

import scala.util.Try

trait PostRepository {
  def findByUser(userId: String) : Try[Seq[Post]]

  def insert(post: Post, userId: String): Try[Long]
}
