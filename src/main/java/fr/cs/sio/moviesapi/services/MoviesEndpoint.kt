package fr.cs.sio.moviesapi.services

import fr.cs.sio.moviesapi.data.MoviesRepository
import java.io.IOException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * An API endpoint to access a list of movies.
 * This endpoint only supports the HTTP method GET.
 */
// A Servlet class must have the @WebServlet annotation to be bounded to requests when the server runs.
// The "name" parameter in only relevant to identify the servlet internally.
// The "value" parameter defines a list of URL patterns that will be routed to this servlet.
@WebServlet(name = "Movies", value = ["/movies"])
// This class extends ApiEndpoint, our base class for all API endpoint servlets.
// Kotlin: No visibility modifier, the default is public.
// Kotlin: Note the parenthesis after the parent class, they denote the call to the constructor (mandatory).
class MoviesEndpoint : ApiEndpoint() {

    // Kotlin: Exceptions are not part of the signature, but you can declare them with this annotation (documentation).
    @Throws(IOException::class)
    // In a servlet class, simply override the do***() methods to add support for a HTTP method.
    // Such methods return nothing, they must use the "response" parameter to send content to the client.
    // Kotlin: This method overrides a method of the parent class, the "override" modifier in mandatory.
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        // Do NOT call super.doGet() in this case, since the parent implementation will send an error response!

        //TODO: Here we could parse query parameters and pass them to the repository.
        //val title = request.getParameter("title")

        // Obtain the unique instance of the MoviesRepository, and get a list of movies.
        // Kotlin: We don't need to specify the variable type, the compiler can infer it from the getMovies() call.
        val movies = MoviesRepository.instance.getMovies()

        // Use our utility method from the parent class to send the response (protected access is OK in a child class).
        sendJsonResponse(response, movies)

    }

}
