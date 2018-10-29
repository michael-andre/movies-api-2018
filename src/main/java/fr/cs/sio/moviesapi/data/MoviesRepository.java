package fr.cs.sio.moviesapi.data;

import fr.cs.sio.moviesapi.data.flat.MoviesRepositoryImpl;
import fr.cs.sio.moviesapi.model.Movie;

import java.util.List;

public interface MoviesRepository {

    static MoviesRepository getInstance() {
        return MoviesRepositoryImpl.getInstance();
    }

    List<Movie> getMovies();

}
