package fr.cs.sio.moviesapi.services

import com.google.gson.GsonBuilder
import fr.cs.sio.moviesapi.services.gson.LocalDateAdapter
import fr.cs.sio.moviesapi.services.gson.EnumAdapterFactory
import java.time.LocalDate
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletResponse

/**
 * A base class for all our API endpoints.
 */
// This class extends the HttpServlet class, provided by the Java Servlet API (javax.servlet-api dependency).
// This class has no abstract methods, neither do the parent class.
// But this is still a good practice to make it abstract because we intend it to be subclassed.
abstract class ApiEndpoint : HttpServlet() {

    private val gson = GsonBuilder()
            .registerTypeAdapterFactory(EnumAdapterFactory)
            .registerTypeAdapter(LocalDate::class.java, LocalDateAdapter)
            .create()

    /**
     * Utility method to write an abject to an @{HttpServletResponse} as JSON.
     * This method relies on the Gson library for encoding.
     */
    // Give protected visibility to this method for subclasses.
    // Kotlin: This method can receive anything as "data" for encoding including primitives (Any) and also null (?).
    protected fun sendJsonResponse(response: HttpServletResponse, data: Any?) {

        // The HTTP protocol requires that the MIME type of the response is sent as a "header" (metadata).
        // We can use response.setHeader() for this, but there are also shorthand setters for common headers.
        response.contentType = "application/json"

        // Then we can convert the data object to JSON an write to the response.
        response.writer.print(gson.toJson(data))
    }

}