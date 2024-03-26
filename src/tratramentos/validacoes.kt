package tratramentos

import java.util.Scanner

val leitura = Scanner(System.`in`)
fun validarQuantidadeCartas(quantidadeCartas : String) : Int {

    while (quantidadeCartas != "5" && quantidadeCartas != "10") {
        println("Valor inválido. Informe '5' ou '10':")
        return validarQuantidadeCartas(leitura.nextLine())
    }

    return  quantidadeCartas.toInt()
}