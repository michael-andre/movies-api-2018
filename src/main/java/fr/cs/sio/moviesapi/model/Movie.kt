package fr.cs.sio.moviesapi.model

import java.time.LocalDate
import java.util.Date
import java.util.EnumSet

/**
 * A model class to represent a movie.
 */
// Keep model class simple, with only properties to store the information.
// Kotlin: "data" classes are special classes dedicated to represent model objects.
// Kotlin: In data classes, properties are declared in the constructor of the class (note the parenthesis).
data class Movie(

        // Kotlin: The following declaration defines a constructor parameter that will also be stored as a public property.
        // Kotlin: For a read/write property (var), the compiler will generate a getter, setter, and a hidden field.
        // Kotlin: For a read-only property (val), the compiler will generate a getter and a hidden field.
        val id: Long,

        val title: String,

        // We chose to expose the relationship with cast and crew members with a List of Person instances.
        // This choice was mainly dictated by the need to easily expose this information to clients of our API.
        // But when *persisting* data, we will rely on a dedicated mechanism, that will vary with the storage layer.
        // For a database, it will probably involve ids, foreign keys, joins, join tables, etc.
        // Kotlin: A parameter/property can be given a default value, so you can omit it when calling the constructor.
        val directors: List<Person>? = null,

        val actors: List<Person>? = null,

        val releaseDate: LocalDate? = null,

        // The platform contains a dedicated type for a set of enum values, with a very optimized implementation.
        val genres: EnumSet<Genre>? = null

) {

    // We could override (redefine) the toString() method to log something meaningful (e.g. for logging).
    // Kotlin: BUT for "data" classes we don't need to do it, the compiler automatically generates it.
    // Kotlin: Note the very short syntax to define a one-line method (the return type is inferred by the compiler).
    // Kotlin: Support for string templates (with $var for variables or ${...} for complex expressions).
    //override fun toString() = "Movie $id: $title"

}