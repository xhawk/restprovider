package controllers

import com.liferay.portal.kernel.exception.SystemException
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import scala.util.parsing.json.{JSONObject, JSONArray}
import utils.ComponentRegistry

/**
 * Agile Hedgehog
 * Change this file to scala
 */
@Path("/articles")
class LiferayRestApiScala {

  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def getArticles: String = {
    try {
      var result: List[JSONObject] = List()
      for (article <- ComponentRegistry.articleService.getArticles) {
        result ::= new JSONObject(article)
      }

      new JSONArray(result).toString()
    }
    catch {
      case e: SystemException =>
        e.getMessage
    }
  }
}
