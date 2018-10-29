package fr.cs.sio.moviesapi.data

import fr.cs.sio.moviesapi.data.flat.MoviesRepositoryImpl
import fr.cs.sio.moviesapi.model.Movie

interface MoviesRepository {

    fun getMovies() : List<Movie>

    companion object {

        val instance: MoviesRepository
            get() = MoviesRepositoryImpl

    }

}
