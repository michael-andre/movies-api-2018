package fr.cs.sio.moviesapi.services;

import com.google.appengine.api.utils.SystemProperty;
import fr.cs.sio.moviesapi.data.MoviesRepository;
import fr.cs.sio.moviesapi.data.flat.MoviesRepositoryImpl;
import fr.cs.sio.moviesapi.model.Movie;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloAppEngine", value = "/hello")
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    response.setContentType("text/plain");

    List<Movie> movies = MoviesRepository.getInstance().getMovies();
    response.getWriter().println(movies.toString());

  }

  public static String getInfo() {
    return "Version: " + System.getProperty("java.version")
          + " OS: " + System.getProperty("os.name")
          + " User: " + System.getProperty("user.name");
  }

}
