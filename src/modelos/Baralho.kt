package modelos

data class Baralho(var quantidadeCartas : Int, var cartas : MutableList<Carta>) {

    companion object {

        private val cartasPartida = mutableListOf<Carta>()

        fun gerarBaralho(quantidadeCartas: Int): Baralho {

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