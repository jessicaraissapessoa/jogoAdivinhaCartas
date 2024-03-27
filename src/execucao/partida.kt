package execucao

import modelos.Baralho
import modelos.Carta
import tratamentos.validarPalpite
import tratamentos.validarQuantidadeCartas
import java.util.Scanner

fun iniciarPartida(leitura : Scanner) {

    var pontuacao = 0
    var tentativas = 0
    val quantidadeCartas : Int

    println("$separador\nBem-vindo ao jogo Adivinha Cartas!" +
            "\nVocê deve adivinhar as cartas do baralho\n$separador\n")

    println("Quantas cartas deseja adivinhar? Informe '5' ou '10':")
    quantidadeCartas = validarQuantidadeCartas(leitura.nextLine())

    val baralho = Baralho.gerarBaralho(quantidadeCartas)

    //println(baralho) //Visualização das cartas para testes

    println("\n$separador\nREGRAS:" +
            "\n- Você deve adivinhar $quantidadeCartas cartas" +
            "\n- Palpite uma carta informando 'cor número'. Ex: vermelho 10" +
            "\n- Cada acerto remove do baralho a carta correspondente" +
            "\n- Caso acerte uma carta que se repete no baralho, só será removida uma por palpite acertado" +
            "\n- O jogo acaba quando acertar as $quantidadeCartas cartas do baralho" +
            "\n- Para desistir, digite 'sair' no palpite" +
            "\n- Pontuação por acerto: 5 pontos / Pontuação por erro: -1 ponto" +
            "\n$separador")

    do {

        println("Cores possíveis: " + Carta.exibirCores())
        println("Números possíveis: " + Carta.exibirNumeros())
        println(separador)

        println("\nDê um palpite de carta ('cor numero'). Ex: azul 1")
        val palpite = leitura.nextLine()

        println("\n$separador")

        if (palpite.equals("sair", ignoreCase = true)) {
            break
        } else {
            val palpiteValidado = validarPalpite(palpite)
            tentativas++
            val sucessoPalpite = efetuarPalpite(baralho, palpiteValidado)

            pontuacao = if (sucessoPalpite) {
                alterarPontuacao(true, pontuacao)
            } else {
                alterarPontuacao(false, pontuacao)
            }

        }
    } while (baralho.cartas.isNotEmpty() && !palpite.equals("sair", ignoreCase = true))

    if (baralho.cartas.isEmpty()) {
        println("Parabéns! Você adivinhou todas as cartas!" +
                "\nTentativas: $tentativas / Pontuação: $pontuacao ponto(s)" +
                "\n$separador\n")
    } else {
        println("Jogo encerrado" +
                "\nTentativas: $tentativas / Pontuação: $pontuacao ponto(s)" +
                "\n$separador\nAs cartas restantes eram as seguintes:" +
                "\n$baralho" +
                "\n$separador\n")
    }

}

fun efetuarPalpite(baralho: Baralho, palpite : String) : Boolean {

    val indiceBuscaEmBaralho = baralho.cartas.indexOfFirst {
        it.toString() == palpite
    }

    return if (indiceBuscaEmBaralho != -1) {

        baralho.cartas.removeAt(indiceBuscaEmBaralho)

        println("Você acertou uma carta! Parabéns!" +
                "\nRestam ${baralho.cartas.size} carta(s)" +
                "\n$separador")

        true

    } else {

        println("Palpite errado\n$separador")
        false
    }
}

fun alterarPontuacao(acerto : Boolean, pontuacao : Int) : Int {

    return if (acerto) {
        pontuacao + 5
    } else {
        pontuacao - 1
    }
}

const val separador = "**********************************************************************"