package fr.cs.sio.moviesapi.data.flat

import fr.cs.sio.moviesapi.data.PersonsRepository
import fr.cs.sio.moviesapi.model.Person
import fr.cs.sio.moviesapi.model.Role
import java.util.*

object PersonsRepositoryImpl : PersonsRepository {

    internal val scarlettJohansson = Person(
            id = 1L,
            firstName = "Scarlett",
            lastName = "Johansson",
            roles = EnumSet.of(Role.ACTOR)
    )
    internal val lucBesson = Person(
            id = 2L,
            firstName = "Luc",
            lastName = "Besson",
            roles = EnumSet.of(Role.DIRECTOR)
    )
    internal val francoisCluzet = Person(
            id = 3L,
            firstName = "François",
            lastName = "Cluzet",
            roles = EnumSet.of(Role.ACTOR)
    )
    internal val omarSy = Person(
            id = 4L,
            firstName = "Omar",
            lastName = "Sy",
            roles = EnumSet.of(Role.ACTOR)
    )
    internal val olivierNakache = Person(
            id = 5L,
            firstName = "Olivier",
            lastName = "Nakache",
            roles = EnumSet.of(Role.DIRECTOR)
    )
    internal val ericToledano = Person(
            id = 6L,
            firstName = "Éric",
            lastName = "Toledano",
            roles = EnumSet.of(Role.DIRECTOR)
    )
    internal val liamNeeson = Person(
            id = 7L,
            firstName = "Liam",
            lastName = "Neeson",
            roles = EnumSet.of(Role.ACTOR)
    )
    internal val olivierMegaton = Person(
            id = 8L,
            firstName = "Olivier",
            lastName = "Megaton",
            roles = EnumSet.of(Role.DIRECTOR)
    )
    internal val bruceWillis = Person(
            id = 9L,
            firstName = "Bruce",
            lastName = "Willis",
            roles = EnumSet.of(Role.ACTOR)
    )
    internal val millaJovovich = Person(
            id = 10L,
            firstName = "Milla",
            lastName = "Jovovich",
            roles = EnumSet.of(Role.ACTOR)
    )

    private val allPersons = setOf(
            scarlettJohansson,
            lucBesson,
            francoisCluzet,
            omarSy,
            olivierNakache,
            ericToledano,
            liamNeeson,
            olivierMegaton,
            bruceWillis,
            millaJovovich
    )

    override fun getPersons(roles: EnumSet<Role>?, query: String?) = allPersons.filter { person ->
        true
    }

}