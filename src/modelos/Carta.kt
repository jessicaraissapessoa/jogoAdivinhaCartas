package modelos

data class Carta(val cor : String, val numero : Int) {

    companion object {

        val cores = arrayOf("preto", "azul", "vermelho")
        val numeros = (1..10).toList()

        private val coresString = StringBuilder().apply {
            for ((index, cor) in cores.withIndex()) {
                append(cor)
                if (index < cores.size - 1) {
                    append(", ")
                }
            }
        }.toString()

        private val numerosString = StringBuilder().apply {
            for ((index, numero) in numeros.withIndex()) {
                append(numero)
                if (index < numeros.size - 1) {
                    append(", ")
                }
            }
        }.toString()

        fun gerarCarta() : Carta {
            val cor = cores.random()
            val numero = numeros.random()
            return Carta(cor, numero)
        }

        fun exibirCores(): String {
            return coresString
        }

        fun exibirNumeros(): String {
            return numerosString
        }
    }

    override fun toString(): String {
        return "$cor $numero"
    }
}