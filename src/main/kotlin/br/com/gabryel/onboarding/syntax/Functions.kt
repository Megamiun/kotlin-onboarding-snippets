package br.com.gabryel.onboarding.syntax

import java.time.LocalDate

class FunctionsHolder {
    companion object {
        fun staticFunction() { }
    }

    fun instanceFunctionWithNoParameters() { }

    fun instanceFunctionWithParameters(parameter: String) { }

    fun instanceFunctionWithDefaultParameters(parameter: String = "default") { }

    fun functionWithNoReturn() { }

    fun functionWithReturn(): String {
        return "return"
    }

    fun functionWithAnImplicitReturn() = "return"
}

fun functionWithoutClass() { }

fun <T> genericFunction(generic: T) { }

inline fun inlineFunction() { }

inline fun <reified T> reifiedFunction() {
    "".byteInputStream()
    println(T::class.java)
}

fun String.extensionFunction() {
    println(this)
}