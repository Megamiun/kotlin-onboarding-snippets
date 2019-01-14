package br.com.gabryel.onboarding.snippets

// Versão 1 - Acoplada a classe Hello
class Hello {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Hi")
        }
    }
}

// Versão 2 - Desacoplada de uma classe. A tempo de compilação será criado uma classe HelloKt para conter esse método
fun main() {
    println("Hi!")
}