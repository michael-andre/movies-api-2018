package fr.cs.sio.moviesapi.model

import java.util.Date
import java.util.EnumSet

class Movie {

    var id = 0L
    var title: String? = null
    var directors: List<Person>? = null
    var actors: List<Person>? = null
    var releaseDate: Date? = null
    var genres: EnumSet<Genre>? = null

    override fun toString() = title ?: ""

}
