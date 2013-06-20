package code
package snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import code.lib._
import Helpers._
import net.liftweb.http.{SHtml, S}

class addItem {

  def render = {

    var returnDate = ""

    def process() {
      S.notice("Return Date: " + returnDate)
    }
    "name=nextMOTDate" #> SHtml.text(returnDate, returnDate = _) &
      "type=submit" #> SHtml.submit("Add", process)
  }
}
