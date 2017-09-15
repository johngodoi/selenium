import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.scalatest.selenium._
import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}


/**
  * @author john
  * @since 05/09/17
  */
class Starter extends FlatSpec with BeforeAndAfterAll with Matchers with WebBrowser {

  ChromeDriverManager.getInstance.setup()

  implicit val webDriver: WebDriver = new ChromeDriver()

  setCaptureDir("./captures")

  val host = "http://www.scalatest.org/user_guide/using_selenium"

  "The blog app home page" should "have the correct title" in {
    go to (host /*+ "index.html"*/)
    pageTitle should be ("ScalaTest")
    val file = capture
    capture to "MyScreenShot.png"
  }
}

