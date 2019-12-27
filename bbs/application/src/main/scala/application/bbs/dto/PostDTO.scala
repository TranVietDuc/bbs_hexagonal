package application.bbs.dto

import java.util.Date

case class PostDTO(id: String, title: String, content: String, userId: String, createdDate: Date)
