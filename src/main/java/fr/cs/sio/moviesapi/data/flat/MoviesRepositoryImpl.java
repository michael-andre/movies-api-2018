package fr.cs.sio.moviesapi.data.flat;

import fr.cs.sio.moviesapi.data.MoviesRepository;
import fr.cs.sio.moviesapi.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MoviesRepositoryImpl implements MoviesRepository {

    private static MoviesRepositoryImpl instance;

    public static MoviesRepositoryImpl getInstance() {
        if (instance == null) instance = new MoviesRepositoryImpl();
        return instance;
    }

    private MoviesRepositoryImpl() {
    }

    @Override
    public List<Movie> getMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        Movie m1 = new Movie();
        m1.setTitle("La Grande Vadrouille");
        movies.add(m1);
        return movies;
    }

}
