package fr.cs.sio.moviesapi.services.gson

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object LocalDateAdapter : TypeAdapter<LocalDate>() {

    override fun write(writer: JsonWriter, value: LocalDate?) {
        when (value) {
            null -> writer.nullValue()
            else -> writer.value(DateTimeFormatter.ISO_DATE.format(value))
        }
    }

    override fun read(reader: JsonReader): LocalDate? {
        return when (reader.peek()) {
            JsonToken.NULL -> null
            else -> LocalDate.parse(reader.nextString(), DateTimeFormatter.ISO_DATE)
        }
    }

}