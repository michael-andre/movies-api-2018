package fr.cs.sio.moviesapi.services.gson

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

object EnumAdapterFactory : TypeAdapterFactory {

    override fun <T : Any?> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {
        return if (type.rawType.isEnum) {
            @Suppress("unchecked_cast")
            EnumAdapter(type.rawType.asSubclass(Enum::class.java)) as TypeAdapter<T>
        } else {
            null
        }
    }

    class EnumAdapter<T : Enum<*>>(type: Class<T>) : TypeAdapter<T>() {

        private val values = type.enumConstants.associateBy { it.name.toLowerCase() }

        override fun write(writer: JsonWriter, value: T?) {
            writer.value(value?.name?.toLowerCase())
        }

        override fun read(reader: JsonReader): T? = when (reader.peek()) {
            JsonToken.NULL -> null
            else -> values[reader.nextString()]
        }

    }

}