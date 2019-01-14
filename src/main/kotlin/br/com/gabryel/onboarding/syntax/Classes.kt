package br.com.gabryel.onboarding.syntax

class BodylessClass

class ClassWithEmptyConstructor {
    fun function() { }
}

class ClassWithConstructor(
    private val immutableValue: String,
    private var mutableValue: String,
    parameterUsedOnlyOnInit: String
) {
    private val lengthOfParameterUsedOnlyOnInit = parameterUsedOnlyOnInit.length
}

class GenericClass<T>

data class DataClass(val name: String)

object Singleton

interface SimpleInterface {
    val field: String

    fun function()
}

abstract class AbstractImplementation: SimpleInterface

class InterfaceImplementation: SimpleInterface {
    override val field = "field"

    override fun function() { }
}

class ConcreteImpletementation: AbstractImplementation() {
    override val field = "field"

    override fun function() { }
}