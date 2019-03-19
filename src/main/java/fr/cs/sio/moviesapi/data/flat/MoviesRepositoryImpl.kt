package fr.cs.sio.moviesapi.data.flat

import fr.cs.sio.moviesapi.data.MoviesRepository
import fr.cs.sio.moviesapi.model.Genre
import fr.cs.sio.moviesapi.model.Movie
import java.time.LocalDate
import java.time.Month
import java.util.*

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
    // Source: https://fr.wikipedia.org/wiki/Liste_des_plus_gros_succ%C3%A8s_fran%C3%A7ais_au_box-office_mondial
    private val allMovies = listOf(
            Movie(
                    // Kotlin: We can explicit the names of the constructor's parameter.
                    id = 1L,
                    title = "Lucy",
                    releaseDate = LocalDate.of(2014, Month.AUGUST, 6),
                    genres = EnumSet.of(Genre.SCIENCE_FICTION),
                    directors = listOf(
                            PersonsRepositoryImpl.lucBesson
                    ),
                    actors = listOf(
                            PersonsRepositoryImpl.scarlettJohansson
                    )
            ),
            Movie(
                    id = 2L,
                    title = "Intouchables",
                    releaseDate = LocalDate.of(2011, Month.NOVEMBER, 2),
                    genres = EnumSet.of(Genre.COMEDY, Genre.DRAMA),
                    directors = listOf(
                            PersonsRepositoryImpl.ericToledano,
                            PersonsRepositoryImpl.olivierNakache
                    ),
                    actors = listOf(
                            PersonsRepositoryImpl.francoisCluzet,
                            PersonsRepositoryImpl.omarSy
                    )
            ),
            Movie(
                    id = 3L,
                    title = "Taken 2",
                    releaseDate = LocalDate.of(2012, Month.OCTOBER, 3),
                    genres = EnumSet.of(Genre.ACTION),
                    directors = listOf(
                            PersonsRepositoryImpl.olivierMegaton
                    ),
                    actors = listOf(
                            PersonsRepositoryImpl.liamNeeson
                    )
            ),
            Movie(
                    id = 4L,
                    title = "Taken 3",
                    releaseDate = LocalDate.of(2015, Month.JANUARY, 21),
                    genres = EnumSet.of(Genre.ACTION),
                    directors = listOf(
                            PersonsRepositoryImpl.olivierMegaton
                    ),
                    actors = listOf(
                            PersonsRepositoryImpl.liamNeeson
                    )
            ),
            Movie(
                    id = 5L,
                    title = "Le Cinquième Élément",
                    releaseDate = LocalDate.of(1997, Month.MAY, 7),
                    genres = EnumSet.of(Genre.SCIENCE_FICTION),
                    directors = listOf(
                            PersonsRepositoryImpl.lucBesson
                    ),
                    actors = listOf(
                            PersonsRepositoryImpl.bruceWillis,
                            PersonsRepositoryImpl.millaJovovich
                    )
            )
    )

    // Implement the query to list all movies (simply return our internal implementation).
    override fun getMovies(releaseDateRange: ClosedRange<LocalDate>?, query: String?) = allMovies.filter { movie ->
        releaseDateRange == null || (movie.releaseDate != null && releaseDateRange.contains(movie.releaseDate))
                && (query == null || movie.title.contains(query, ignoreCase = true))
    }

    // Implement the query to a single movie.
    override fun getMovie(id: Long) =
            allMovies.firstOrNull { it.id == id }

}
