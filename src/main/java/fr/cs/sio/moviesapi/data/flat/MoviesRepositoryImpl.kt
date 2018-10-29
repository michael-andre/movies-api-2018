package fr.cs.sio.moviesapi.data.flat

import fr.cs.sio.moviesapi.data.MoviesRepository
import fr.cs.sio.moviesapi.model.Movie

object MoviesRepositoryImpl : MoviesRepository {

    private val allMovies = listOf(Movie().apply {
        id = 1
        title = "La Grande Vadrouille"
    })

    override fun getMovies() = allMovies

    override fun getMovie(id: Long) =
            allMovies.firstOrNull { it.id == id }

}
