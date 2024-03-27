package tratamentos

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

fun validarPalpite(palpite: String): String {

    val cores = Carta.cores
    val numeros = Carta.numeros

    val regexLetra = "[a-zA-Z]+".toRegex()
    val regexNumero = "\\d+".toRegex()

    val corFormada = regexLetra.findAll(palpite).map { it.value }.joinToString("")
    val numeroFormado = regexNumero.findAll(palpite).map { it.value }.joinToString("").toIntOrNull()

    val corEncontrada = cores.find { corFormada.contains(it, ignoreCase = true) }
    val numeroEncontrado = numeros.find { it == numeroFormado }

    val palpiteFormado = "$corEncontrada $numeroEncontrado"

    return if (!corEncontrada.isNullOrBlank() || numeroEncontrado != null) {
        palpiteFormado
    } else {
        validarPalpite(leitura.nextLine())
    }
}

