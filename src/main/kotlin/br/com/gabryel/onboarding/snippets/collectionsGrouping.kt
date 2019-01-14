package br.com.gabryel.onboarding.snippets

fun main(args: Array<String>) {

    val values = listOf("1", "2", 5, 8 to "algo")

    printResult {
        values.groupBy { getClassString(it) }
    }

    printResult {
        values.groupBy(::getClassString) { it.toString() }
    }

    printResult {
        values.associate { it to getClassString(it) }
    }

    printResult {
        values.associateWith { it to getClassString(it) }
    }
}

private fun getClassString(it: Any) = it::class.simpleName