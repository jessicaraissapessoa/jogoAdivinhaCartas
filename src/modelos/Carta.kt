package modelos

import kotlin.random.Random
import kotlin.random.nextInt

data class Carta(val cor : String, val numero : Int) {

    companion object {

        fun gerarCarta() : Carta {

            val cores = arrayOf("preto", "azul", "vermelho")

            val cor = cores.random()
            val numero = Random.nextInt(1 .. 10)

            return Carta(cor, numero)
        }
    }

    override fun toString(): String {
        return "$cor $numero"
    }

}


