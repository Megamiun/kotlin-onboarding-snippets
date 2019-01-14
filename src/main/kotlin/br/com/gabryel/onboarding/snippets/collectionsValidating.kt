package br.com.gabryel.onboarding.snippets

fun main(args: Array<String>) {

    val values = listOf(1, 2, 3)

    printResult { values.any { it % 2 == 0 } }

    printResult { values.all { it % 2 == 0 } }

    printResult { values.none { it % 2 == 0 } }
}