package controllers

import com.liferay.portal.kernel.exception.SystemException
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

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
      val result = JournalArticleLocalServiceUtil.getArticles(10179, -1, -1)
      "{'message': '" + result.size + "'}"
    }
    catch {
      case e: SystemException =>
        return "{'error': '"+ e.getMessage +"'}"
    }
  }
}
