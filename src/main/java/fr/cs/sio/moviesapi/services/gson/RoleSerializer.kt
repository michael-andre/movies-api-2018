package fr.cs.sio.moviesapi.services.gson

import com.google.gson.*
import fr.cs.sio.moviesapi.model.Role
import java.lang.reflect.Type

object RoleSerializer : JsonSerializer<Role> {

    override fun serialize(value: Role?, type: Type, context: JsonSerializationContext?): JsonElement =
            when (value) {
                null -> JsonNull.INSTANCE
                else -> JsonPrimitive(value.name.toLowerCase())
            }

}