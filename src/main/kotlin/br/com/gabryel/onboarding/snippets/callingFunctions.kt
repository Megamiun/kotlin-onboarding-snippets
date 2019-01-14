package br.com.gabryel.onboarding.snippets

fun main() {
    printResult(::hello)
}

fun hello(): String {
    return "Hi"
}

fun <T> printResult(function: () -> T) {
    try {
        println(function())
    } catch (e: Exception) {
        println(e.message)
    }
}