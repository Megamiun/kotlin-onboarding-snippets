package br.com.gabryel.onboarding.challenge

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalStateException

class RepositoryTest {

    @Test
    fun `given five persons saved, when asking for all persons, then should return list of five persons`() {
        val repository = generateRepository()

        val result = repository.getAllPersons()

        assertThat(result, hasSize(5))
    }

    @Test
    fun `given a person with id saved, when asking for a person with same id, then should return instance of Person`() {
        val repository = generateRepository()

        val result = repository.getPersonById(1)

        assertThat(result.name, equalTo("Gabryel"))
    }

    @Test
    fun `given there is no person with id saved, when asking for a person with same id, then should throw NotFoundException`() {
        val repository = generateRepository()

        assertThrows<NotFoundException> {
            repository.getPersonById(6)
        }
    }

    @Test
    fun `given there is no one with height registered, when asking for the higher person, then should return null`() {
        val repository = generateRepository(
            persons = listOf(Person(1, "Gabryel")),
            phones = listOf(Phone(1, 1, "11 953516489"))
        )

        assertThat(repository.getHigherPerson(), nullValue())
    }

    @Test
    fun `given there are persons with height, when asking for the higher person, then should return it`() {
        val repository = generateRepository()

        assertThat(repository.getHigherPerson()?.id, equalTo(3))
    }

    private fun generateRepository(
        persons: List<Person> = defaultListOfPersons(),
        phones: List<Phone> = defaultListOfPhones()
    ): Repository {
        return Repository().apply {
            persons.forEach { save(it) }
            phones.forEach { save(it) }
        }
    }

    private fun defaultListOfPhones(): List<Phone> {
        return listOf(
            Phone(1, 1, "11 956486248"),
            Phone(2, 2, "11 156486248"),
            Phone(3, 3, "11 156486848"),
            Phone(4, 3, "11 156446248"),
            Phone(5, 5, "11 156786248")
        )
    }

    private fun defaultListOfPersons(): List<Person> {
        val videogames = Hobby("Video Games")
        val cooking = Hobby("Cooking")

        return listOf(
            Person(1, "Gabryel"),
            Person(2, "Joaquim", PersonalInfo(1.56, listOf(videogames))),
            Person(3, "Jonas", PersonalInfo(2.0, listOf(cooking))),
            Person(4, "Joana", PersonalInfo(1.85, listOf(videogames, cooking))),
            Person(5, "Jonathan", PersonalInfo(1.76, emptyList()))
        )
    }
}

class RepositoryReaderTest {

    @Test
    fun `given a Repository where no one has hobbies, when asking for first hobby, should throw IllegalStateException with HOW CAN NO ONE IN THE DATABASE HAVE HOBBIES! as message`() {
        val repository = mock<Repository> {
            on { getAllRegisteredHobbies() } doReturn setOf()
        }

        val reader = RepositoryReader(repository)

        val exception = assertThrows<IllegalStateException> {
            reader.getFirstHobby()
        }

        assertThat(exception.message, equalTo("HOW CAN NO ONE IN THE DATABASE HAVE HOBBIES!"))
    }

    @Test
    fun `given a Repository where there are hobbies, when asking for first hobby, should return first on repository`() {
        val repository = mock<Repository> {
            on { getAllRegisteredHobbies() } doReturn setOf(Hobby("Fishing"), Hobby("Cooking"))
        }

        val reader = RepositoryReader(repository)

        assertThat(reader.getFirstHobby(), equalTo(Hobby("Fishing")))
    }
}