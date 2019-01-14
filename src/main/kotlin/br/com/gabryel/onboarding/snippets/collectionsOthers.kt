package br.com.gabryel.onboarding.snippets

fun main(args: Array<String>) {

    val values = listOf(1, 2, 3)

    printResult { values.asReversed() }

    printResult { values.drop(1) }

    printResult { values.slice(1..2) }

    printResult { values.takeLast(4) }

    printResult { values.zip(listOf(9, 8, 7)) }

    printResult { values.fold(0) { previous, current -> previous * current} }
}