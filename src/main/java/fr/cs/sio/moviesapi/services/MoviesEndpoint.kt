package fr.cs.sio.moviesapi.services

import fr.cs.sio.moviesapi.data.MoviesRepository
import java.io.IOException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "Movies", value = "/movies")
class MoviesEndpoint : ApiEndpoint() {

    @Throws(IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val movies = MoviesRepository.instance.getMovies()
        sendResponse(response, movies)
    }

}
