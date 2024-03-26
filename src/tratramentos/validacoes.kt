package tratramentos

import modelos.Carta
import java.util.Scanner

val leitura = Scanner(System.`in`)
fun validarQuantidadeCartas(quantidadeCartas : String) : Int {

    while (quantidadeCartas != "5" && quantidadeCartas != "10") {
        println("Valor inválido. Informe '5' ou '10':")
        return validarQuantidadeCartas(leitura.nextLine())
    }

    return  quantidadeCartas.toInt()
}


fun validarPalpite(palpite : String) : Boolean {

    val cores = Carta.cores
    val numeros = Carta.numeros

    val corValida = cores.any {
        palpite.contains(it, ignoreCase = true)
    }

    val numeroValido = numeros.any {
        palpite.contains(it.toString())
    }

    while (!corValida || !numeroValido) {
        println("Palpite inválido. Informe palpite no formato/sequência 'cor numero' (Ex: azul 1):")
        return validarPalpite(leitura.nextLine())
    }

    /* Como seria validação com regex:
    fun validarPalpite(palpite: String): Boolean {
        val formatoCorNumero = Regex("""^\s*(preto|azul|vermelho)\s+\d{1,2}\s*$""")
        return formatoCorNumero.matches(palpite.trim())
    }*/

    return true
}