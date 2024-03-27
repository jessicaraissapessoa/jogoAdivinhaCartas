package execucao

import java.util.*

fun main() {

    val leitura = Scanner(System.`in`)

    do {
        iniciarPartida(leitura)

        println("Deseja jogar outra partida? Digite 's' para jogar novamente")
        val jogar = leitura.nextLine()

        println("")

    } while (jogar.contains("s", ignoreCase = true))

    println("${separador}\nAté a próxima!\n$separador")

}