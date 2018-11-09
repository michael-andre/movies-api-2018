package fr.cs.sio.moviesapi.services

import fr.cs.sio.moviesapi.data.MoviesRepository
import java.io.IOException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * An API endpoint to access a single movie by its id.
 * This endpoint only supports the HTTP method GET.
 */
// We can use * in the value to define a generic pattern that will match any URL starting with "/movies/".
// Though, we have no way to restrict it to digits only, so we will have to check it later.
@WebServlet(name = "Movie", value = ["/movies/*"])
class MovieEndpoint : ApiEndpoint() {

    @Throws(IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {

        // Extract the id from the URL using a nice chain of method calls:
        // - getPathInfo() on HttpServletRequest gives us access to the path part of URL (after the domain).
        // - split() on String allows us to obtain each parts of the path as a List of Strings.
        // - last() on List gives access to the last element (throws an exception if the list is empty).
        // - toLong() converts a String into a Long (throws an exception if the string is not a proper number).
        // Kotlin: The last 3 methods are actually "extension methods" of the classes CharSequence, List<T> and String.
        // Kotlin: Extension methods are declared in independent files, but we can use them like usual methods.
        // Kotlin: The call getPathInfo() is replaced by the equivalent pathInfo property access syntax.
        val id = request.pathInfo.split("/").last().toLong()
        //TODO: The previous line will fail if the URL doesn't contain a proper id, we should handle this case.

        // Obtain the unique instance of the MoviesRepository, and get the movie.
        val movie = MoviesRepository.instance.getMovie(id)
        //TODO: Deal properly with the case where there is no movie with this id (404 error).

        sendJsonResponse(response, movie)

    }

}
