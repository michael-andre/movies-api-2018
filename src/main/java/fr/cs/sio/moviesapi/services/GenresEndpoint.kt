package fr.cs.sio.moviesapi.services

import fr.cs.sio.moviesapi.model.Genre
import java.io.IOException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "Genres", value = ["/genres"])
class GenresEndpoint : ApiEndpoint() {

    @Throws(IOException::class)
    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        val genres = Genre.values().sortBy { it.name }
        sendJsonResponse(resp, genres)
    }

}