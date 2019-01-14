package br.com.gabryel.onboarding.challenge

import java.lang.Exception
import java.lang.IllegalStateException

data class Hobby(val name: String)

class NotFoundException: Exception()

class PersonalInfo(
    val height: Double,
    val hobbies: List<Hobby>
)

class Person(
    val id: Int,
    val name: String,
    val personal: PersonalInfo? = null
)

class Phone(
    val id: Int,
    val personId: Int,
    val phoneNumber: String
)

open class Repository {

    // Map the items with the item id as key and the object as value
    private val people = mutableMapOf<Int, Person>()

    private val phones = mutableMapOf<Int, Phone>()

    fun save(person: Person) {
        people[person.id] = person
    }

    fun save(phone: Phone) {
        phones[phone.id] = phone
    }

    fun getAllPersons(): List<Person> {
        TODO()
    }

    fun getPersonById(id: Int): Person {
        TODO()
    }

    fun getPersonByName(name: String): Person {
        TODO()
    }

    fun getPersonsThatHaveHobby(hobby: Hobby): List<Person> {
        TODO()
    }

    fun getPersonsLowerThan(height: Double): List<Person> {
        TODO()
    }

    fun getHigherPerson(): Person? {
        TODO()
    }

    fun getPersonThatHaveMoreHobbies(): Person {
        TODO()
    }

    open fun getAllRegisteredHobbies(): Set<Hobby> {
        TODO()
    }

    fun getOrderedListOfHeights(): List<Double> {
        TODO()
    }

    fun getAllPhones(): List<Phone> {
        TODO()
    }

    fun getPhoneById(id: Int): Phone {
        TODO()
    }

    fun getAllPhonesFromPerson(id: Int): List<Phone> {
        TODO()
    }

    fun getAllPhonesFromPersonsWhoHaveHobby(hobby: Hobby): List<Phone> {
        TODO()
    }

    fun getPersonByPhoneId(id: Int): Person {
        TODO()
    }
}

class RepositoryReader(private val repository: Repository) {

    fun getFirstHobby(): Hobby {
        return repository.getAllRegisteredHobbies().firstOrNull()
            ?: throw IllegalStateException("HOW CAN NO ONE IN THE DATABASE HAVE HOBBIES!")
    }
}