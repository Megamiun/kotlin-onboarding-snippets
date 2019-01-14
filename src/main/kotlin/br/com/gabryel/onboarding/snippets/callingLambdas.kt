package br.com.gabryel.onboarding.snippets

fun main() {

    printResult { hello() }

    printResult { check(5) { it < 10} }

    printResult {
        val randomDouble = Math.random()

        if (randomDouble.toString().contains("6")) {
            return@printResult true
        }

        false
    }
}

fun check(number: Int, checker: (Int) -> Boolean) = checker(number)