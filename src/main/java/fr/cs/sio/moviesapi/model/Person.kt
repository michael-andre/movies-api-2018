package fr.cs.sio.moviesapi.model

import java.util.EnumSet

class Person {

    var id = 0L
    var firstName: String? = null
    var lastName: String? = null
    var roles: EnumSet<Role>? = null

}