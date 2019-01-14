package br.com.gabryel.onboarding.syntax

// In kotlin we have lots of ways to declare values.
fun main(args: Array<String>) {

    val immutableValue = "I can't point to any other object once I have been set"

    var mutableValue = "If someone wants, I can point to any other object any time you want"
    mutableValue = "Oops, I am pointing to a new object"

    val typedValue: String = "You have already declared my type explicitly"

    val lazyValue by lazy {
        println("You needed me")
        "I'll not load until someone need me"
    }

    println("Maybe you will need me?")

    lazyValue

    val possiblyNullValue: String? = createPossiblyNullString(false)

    val nullValue: String? = createPossiblyNullString(true)
}

private fun createPossiblyNullString(shouldBeNull: Boolean): String? {
    return if (shouldBeNull) null else "Not null value"
}