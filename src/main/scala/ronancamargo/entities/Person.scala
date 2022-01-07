package ronancamargo.entities

import java.time.LocalDateTime

case class Person(
    id: Int,
    firstName: String,
    lastName: String,
    identification: Int,
    age: Int,
    address: String,
    city: String,
    country: Int,
    creationDateTime: LocalDateTime
)
