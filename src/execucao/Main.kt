package execucao

import modelos.Carta
import java.util.*

fun main() {

//    //Teste de geração de cartas
//    var i = 0
//    while (i < 20) {
//        var carta = Carta.gerarCarta()
//        println(carta.toString())
//        i++
//    }

    val leitura = Scanner(System.`in`)
    var jogar = "s"

    while (jogar == "s") {
        iniciarPartida(leitura)

        println("Deseja jogar outra partida?")
        jogar = leitura.nextLine()
    }

    println("Até a próxima!")

}

//números 1 a 10
//cores: preto, vermelho, azul
//acerto: 5 pts / erro: -1 pt
//5 ou 10 cartas aleatórias
// acerto -> remove carta
//fim -> acertar todas ou desistir