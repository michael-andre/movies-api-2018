package fr.cs.sio.moviesapi.model

data class ApiError(

        val error: String,

        val errorDescription: String? = null

)