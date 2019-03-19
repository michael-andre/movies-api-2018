package fr.cs.sio.moviesapi.services.gson

import com.google.gson.*
import java.lang.reflect.Type
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object LocalDateSerializer : JsonSerializer<LocalDate> {

    override fun serialize(value: LocalDate?, type: Type, context: JsonSerializationContext): JsonElement? =
            when (value) {
                null -> JsonNull.INSTANCE
                else -> JsonPrimitive(DateTimeFormatter.ISO_DATE.format(value))
            }

}