package bbs.port.primary.http.adapter.controller.common

import bbs.port.primary.http.adapter.models.{APIResult, ResponseJson}
import com.github.tototoshi.play2.json4s.Json4s
import org.json4s.{DefaultFormats, Extraction}
import play.api.i18n.{I18nSupport, Langs}
import play.api.libs.json.DefaultFormat
import play.api.mvc.{AbstractController, ControllerComponents, Result}

abstract class APIController(cc: ControllerComponents, lang: Langs) extends AbstractController(cc) with I18nSupport {
protected val json4s: Json4s
  import json4s.implicits._
  implicit val formats: DefaultFormats.type = DefaultFormats

  protected def success[T <: ResponseJson](result: T): Result =
    Ok(Extraction.decompose(APIResult.toSuccessJson(result)))

  protected def success[T <: ResponseJson](result: Seq[T]): Result =
    Ok(Extraction.decompose(APIResult.toSuccessJson(result)))

  protected def failure[T <: ResponseJson](result: Seq[T]): Result =
    Ok(Extraction.decompose(APIResult.toFailureJson(result)))

  protected def failure(): Result =
    Ok(Extraction.decompose(APIResult.toFailureJson()))

  protected def success(): Result =
    Ok(Extraction.decompose(APIResult.toSuccessJson))

  protected def success(message: String): Result =
    Ok(Extraction.decompose(APIResult.toSuccessJson(message)))

  protected def success(id: Long): Result =
    Ok(Extraction.decompose(APIResult.toSuccessJson(id)))
}
