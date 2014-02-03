package utils

import services.ArticleServiceComponent

/**
 * Context container
 * Cake pattern: http://jonasboner.com/2008/10/06/real-world-scala-dependency-injection-di/
 */
object ComponentRegistry extends ArticleServiceComponent {
  val articleService = new ArticleService
}
