package br.com.gabryel.onboarding.snippets

fun main(args: Array<String>) {

    val values = listOf(1, 2, 3)

    printResult { values.first() }

    printResult { values.find { it % 2 == 0 } }

    printResult { values.first { it % 5 == 0 } }

    printResult { values.firstOrNull { it % 5 == 0 } }

    printResult { values.last { it % 2 == 0 } }
}