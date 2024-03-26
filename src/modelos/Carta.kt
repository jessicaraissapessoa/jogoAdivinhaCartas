package modelos

data class Carta(val cor : String, val numero : Int) {

    companion object {

        val cores = arrayOf("preto", "azul", "vermelho")
        val numeros = (1..10).toList()

        fun gerarCarta() : Carta {

            val cor = cores.random()
            val numero = numeros.random()

            return Carta(cor, numero)
        }
    }

    override fun toString(): String {
        return "$cor $numero"
    }

}


