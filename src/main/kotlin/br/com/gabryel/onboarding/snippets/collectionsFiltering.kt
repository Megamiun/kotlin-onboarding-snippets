package br.com.gabryel.onboarding.snippets

fun main(args: Array<String>) {

    val values = listOf(1, 2, 3, 4, 5, 1000, null, "")

    val numbers = values
        .filterNotNull() // [1, 2, 3, 4, 5, 1000, ""]
        .filterIsInstance<Int>() // [1, 2, 3, 4, 5, 1000]
        .filter { it < 100 }  // [1, 2, 3, 4, 5]
        .filterNot { it == 5 }  // [1, 2, 3, 4]
        .filterIndexed { index, _ -> index % 2 == 0 }

    printResult { numbers }

    printResult {
        val result = mutableListOf<Int>()

        numbers.filterTo(result) { it % 2 == 0 }

        result
    }
}