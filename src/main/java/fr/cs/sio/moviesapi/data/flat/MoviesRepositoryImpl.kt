package fr.cs.sio.moviesapi.data.flat

import fr.cs.sio.moviesapi.data.MoviesRepository
import fr.cs.sio.moviesapi.model.Movie

import java.util.ArrayList

object MoviesRepositoryImpl : MoviesRepository {

    override fun getMovies() =
            listOf(Movie().apply {
                title = "La Grande Vadrouille"
            })

}
