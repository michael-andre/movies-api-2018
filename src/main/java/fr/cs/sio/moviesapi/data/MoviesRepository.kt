package fr.cs.sio.moviesapi.data

import fr.cs.sio.moviesapi.data.flat.MoviesRepositoryImpl
import fr.cs.sio.moviesapi.model.Movie

/**
 * A base interface for a repository of Movie entities.
 *
 */
// Repository interfaces and classes constitute the data layer of our API.
// As a best practice, we ony describe here the capabilities of a repository (list of methods).
// Concrete classes will be defined to implement if with a database, in-memory storage, etc.
// Outside the data package, other layers should only deal with this interface, and know nothing about implementations.
//TODO: Define additional repository for Persons.
interface MoviesRepository {

    /**
     * Get all movies from the repository.
     */
    //TODO: Add optional parameters or variants to filter movies.
    fun getMovies() : List<Movie>

    /**
     * Find a movie by id.
     * If the movie does not exist, null is returned.
     */
    fun getMovie(id: Long) : Movie?

    //TODO: Add methods for other possible queries related to movies, or closely related.
    //fun getGenres() = Genre.values()

    // Kotlin: In Kotlin, there is not concept of "static" members of a class.
    // Kotlin: Instead, you group these members into a "Companion object" of the enclosing type.
    // Kotlin: Access will still be transparent from the outside, with MoviesRepository.instance.
    companion object {

        // Kotlin: "val" introduces a readonly property (no setter).
        // Kotlin: In the property declaration, we can redefine the getter (here we always return MoviesRepositoryImpl).
        val instance: MoviesRepository
            get() = MoviesRepositoryImpl

    }

}
