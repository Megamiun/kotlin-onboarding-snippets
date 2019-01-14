package br.com.gabryel.onboarding.snippets

fun main() {
    printResult {
        hello().concatenateWith("you", "you")
    }

    printResult {
        val wrap: String.(String, String) -> String = { prefix, postfix ->
            "$prefix$this$postfix"
        }

        //wrap(hello(), "{", "}")
        hello().wrap("{", "}")
    }
}

fun String.concatenateWith(param1: String, param2: String): String {
    println(this)
    println(param1)
    println(param2)

    return "$this $param1 and $param2"
}