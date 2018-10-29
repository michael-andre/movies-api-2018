package fr.cs.sio.moviesapi.model

import java.util.EnumSet

class Person {

    var id: Long = 0
    var firstName: String? = null
    var lastName: String? = null
    var roles: EnumSet<Role>? = null
}
