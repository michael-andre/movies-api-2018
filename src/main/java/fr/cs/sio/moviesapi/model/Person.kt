package fr.cs.sio.moviesapi.model

import java.util.EnumSet

/**
 * A model class to represent a person.
 * Persons can be part of the cast (actors) and/or the crew (directors, etc.) of a movie.
 */
data class Person(

    val id: Long = 0L,

    val firstName: String? = null,

    val lastName: String? = null,

    // This information is *redundant* with the presence or absence of this Person in the lists of a movie.
    // But we can keep it if it adds value to our API clients.
    // Maybe we will not *store* it, but instead compute it from other relations.
    val roles: EnumSet<Role>? = null

)