package fr.cs.sio.moviesapi.services

import com.google.gson.Gson
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletResponse

abstract class ApiEndpoint : HttpServlet() {

    protected fun sendResponse(response: HttpServletResponse, data: Any) {
        response.contentType = "application/json"
        response.writer.println(Gson().toJson(data))
    }

}