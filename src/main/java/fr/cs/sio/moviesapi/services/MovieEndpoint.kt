package fr.cs.sio.moviesapi.services

import fr.cs.sio.moviesapi.data.MoviesRepository
import java.io.IOException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "Movie", value = "/movies/*")
class MovieEndpoint : ApiEndpoint() {

    @Throws(IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        // TODO: Parse id from URL
        val id = request.pathInfo.split("/").last().toLong()
        val movie = MoviesRepository.instance.getMovie(id)
        sendResponse(response, movie)
    }

}
