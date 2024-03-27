package execucao

import java.util.*

fun main() {

    val leitura = Scanner(System.`in`)
    var jogar = "s"

    while (jogar.contains("s", ignoreCase = true)) {
        iniciarPartida(leitura)

        println("Deseja jogar outra partida? Digite 's' para jogar novamente")
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