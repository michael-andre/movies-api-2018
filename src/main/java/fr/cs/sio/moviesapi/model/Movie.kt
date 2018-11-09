package fr.cs.sio.moviesapi.model

import java.util.Date
import java.util.EnumSet

/**
 * A model class to represent a movie.
 */
// Keep model class simple, with only properties to store the information.
class Movie {

    // Kotlin: The following declaration defines a public pair of getter and setter, and a hidden attribute.
    // Kotlin: We must explicitly provide the default value for properties (unless set in a constructor).
    // Kotlin: For id, the property type is inferred from the default value (0L => Long).
    var id = 0L

    // Kotlin: Here we have to specify the property type, since the compiler cannot guess from the default value.
    var title: String? = null

    // We chose to expose the relationship with cast and crew members with a List of Person instances.
    // This choice was mainly dictated by the need to easily expose this information to clients of our API.
    // But when *persisting* data, we will rely on a dedicated mechanism, that will vary with the storage layer.
    // For a database, it will probably involve ids, foreign keys, joins, join tables, etc.
    var directors: List<Person>? = null

    var actors: List<Person>? = null

    var releaseDate: Date? = null

    // The platform contains a dedicated type for a set of enum values, with a very optimized implementation.
    var genres: EnumSet<Genre>? = null

    // We can override (redefine) the toString() method to log something meaningful (e.g. for logging).
    // Kotlin: Note the very short syntax to define a one-line method (the return type is inferred by the compiler).
    // Kotlin: Support for string templates (with $var for variables or ${...} for complex expressions).
    override fun toString() = "Movie $id: $title"

}