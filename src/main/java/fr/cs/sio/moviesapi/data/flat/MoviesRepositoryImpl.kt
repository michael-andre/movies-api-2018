package fr.cs.sio.moviesapi.data.flat

import fr.cs.sio.moviesapi.data.MoviesRepository
import fr.cs.sio.moviesapi.model.Movie

/**
 * A concrete implementation of @{MoviesRepository} that will store data in-memory.
 * The implementation relies on a predefined list of hard-coded movies.
 */
// Kotlin: Since we only expect to have a single instance of this class, we can use the "object" type in Kotlin.
// Kotlin: This is equivalent to declaring a class with a single instance (avoids the singleton pattern).
// This object implements the MoviesRepository interface.
object MoviesRepositoryImpl : MoviesRepository {

    // Keep an internal variable of all movies.
    // Kotlin: listOf() is a convenient top-level function to easily create an immutable list of values.
    private val allMovies = listOf(
            // Kotlin: apply() in an extension method that take a block of code as its only parameter.
            // Kotlin: When the last parameter of a method is a block, parenthesis are omitted!
            Movie().apply {
                // Kotlin: Inside this block, the scope (this) refers to the subject the apply() method is called on.
                id = 1
                title = "La Grande Vadrouille"
            }
    )

    // Implement the query to list all movies (simply return our internal implementation).
    //TODO: Support filtering movies with optional parameters.
    override fun getMovies() = allMovies

    // Implement the query to a single movie.
    override fun getMovie(id: Long) =
            allMovies.firstOrNull { it.id == id }

}
