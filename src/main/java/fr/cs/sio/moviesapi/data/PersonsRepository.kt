package fr.cs.sio.moviesapi.data

import fr.cs.sio.moviesapi.model.Person
import fr.cs.sio.moviesapi.model.Role
import java.util.*

interface PersonsRepository {

    fun getPersons(
            roles: EnumSet<Role>? = null,
            query: String? = null
    ) : List<Person>

}