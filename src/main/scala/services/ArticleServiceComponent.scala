package services

import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil
import scala.xml.XML
import com.liferay.portlet.journal.model.JournalArticle

/**
 * Returns a list of articles
 */
trait ArticleServiceComponent {
  val articleService: ArticleService

  class ArticleService {

    /**
     * Returns a list of article objects that have id and title
     *
     * @return list of articles
     */
    def getArticles: List[Map[String, Any]] = {
      var result: List[Map[String, Any]] = List()
      val articles = JournalArticleLocalServiceUtil.getArticles(10179, -1, -1).iterator

      while (articles.hasNext) {
        val article: JournalArticle = articles.next
        // create map that presents an article, article title is taken as a text from xml element
        var articleObj: Map[String, String] = Map("title" -> XML.loadString(article.getTitle).text)
        // add id with value to map
        articleObj += ("id" -> article.getId.toString)
        result ::= articleObj
      }
      result
    }
  }
}
