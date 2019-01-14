package br.com.gabryel.onboarding.snippets

fun main(args: Array<String>) {

    val values = listOf("1", 5, null)

    values
        .mapNotNull { toInt(it) } // [1, 5]
        .map { it to it * it } // [(1, 1), (5, 10)]
        .flatMap { listOf(it.first, it.second) } // [1, 1, 5, 10]
}

private fun toInt(it: Any?): Int? {
    return when (it) {
        is Int -> it
        is String -> Integer.parseInt(it)
        else -> null
    }
}