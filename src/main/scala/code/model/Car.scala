package code.model


import net.liftweb.mapper._

class Car extends LongKeyedMapper[Car] with IdPK with OneToMany[Long,Car]{

  def getSingleton = Car

  object deliveryDate extends MappedDate(this) {
    override def dbColumnName = "deliverydate"
  }

}

object Car extends Car with LongKeyedMetaMapper[Car]