import org.openqa.selenium.WebDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.selenium._

/**
  * @author john
  * @since 05/09/17
  */
class Starter extends FlatSpec with Matchers with WebBrowser {

  implicit val webDriver: WebDriver = new HtmlUnitDriver

  val host = "http://www.scalatest.org/user_guide/using_selenium"

  "The blog app home page" should "have the correct title" in {
    go to (host /*+ "index.html"*/)
    pageTitle should be ("ScalaTest")
  }
}