package code.snippet


import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import code.lib._
import Helpers._
import net.liftweb.http.{SHtml, S}
import net.liftweb.http.js.JsCmds.Run
import java.text.SimpleDateFormat
import java.util.{Calendar, Date}
import code.lib._

class addItem {
  val enhance = Run("$('#datepicker').datepicker({dateFormat: 'dd/mm/yy'});")
  val dateFormat = new SimpleDateFormat("dd/MM/yyyy")
  val default = (dateFormat format now)

  def render = {
    val car = code.model.Car.create

    S.appendJs(enhance)

    var returnDate = ""

    def process() {
      car.deliveryDate.set(returnDate)
      car.save
      S.notice("Return Date: " + returnDate)
    }
    "name=returnDate" #> SHtml.text(returnDate, returnDate = _) &
      "type=submit" #> SHtml.submit("Add", process)
  }
}

