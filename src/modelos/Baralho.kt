package modelos

data class Baralho(var quantidadeCartas : Int, var cartas : MutableList<Carta>) {

    companion object {

        fun gerarBaralho(quantidadeCartas: Int): Baralho {

            val cartasPartida = mutableListOf<Carta>()

            repeat(quantidadeCartas) {
                val carta = Carta.gerarCarta()
                cartasPartida.add(carta)
            }

            return Baralho(quantidadeCartas, cartasPartida)
        }
    }

    override fun toString(): String {
        return cartas.joinToString(separator = "\n")
    }
}