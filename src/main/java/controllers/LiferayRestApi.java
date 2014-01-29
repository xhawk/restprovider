package controllers;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Agile Hedgehog
 * Change this file to scala
 */
@Path("/articles")
public class LiferayRestApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getArticles() {
        try {
            List<JournalArticle> result = JournalArticleLocalServiceUtil.getArticles(10179, -1, -1);
            return "{'message': '"+result.size()+"'}";
        } catch (SystemException e) {
            e.printStackTrace();
            return "{'error': 'some error'}";
        }

    }
}
