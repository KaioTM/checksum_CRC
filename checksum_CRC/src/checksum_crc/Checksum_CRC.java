/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checksum_crc;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

/**
 *
 * @author kaio.teixeira
 */
public class Checksum_CRC {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner teclado = new Scanner(System.in);
		ArrayList<String> mensagemDigitada = new ArrayList<String>();
		Binario binario = new Binario();
		Checksum checksum = new Checksum();
		String polinomioGerador;

		// System.out.println("Digite a mensagem:");
		// String mensagemOriginal = teclado.nextLine();
		// binario.converterMensagemParaBinario(mensagemOriginal,
		// mensagemDigitada);
		// System.out.println(mensagemDigitada.get(0));
		// System.out.println(mensagemDigitada.get(1));
		// System.out.println(binario.somaBinario(mensagemDigitada.get(0),
		// mensagemDigitada.get(1)));
		// System.out.println(checksum.checksum(mensagemDigitada,mensagemDigitada.size()));

		Crc crc = new Crc();
		System.out.println("Digite a mensagem:");
		String mensagemOriginal = teclado.nextLine();
		binario.converterMensagemParaBinario(mensagemOriginal, mensagemDigitada);
		System.out.println("Digite o polinomio gerador:");
		polinomioGerador = teclado.nextLine();

		ArrayList<String> polinomio = new ArrayList<String>();
		polinomio = binario.criaBinarioPolinomioGerador(polinomioGerador);
		ArrayList<String> novoArrayMensagem = ajusteArray(mensagemDigitada);
		ArrayList<String> mensagemEnviada = crc.calculaMensagemEnviada(novoArrayMensagem, polinomio, 8);
		mensagemEnviada = ajusteArray(mensagemEnviada);
		
		for (String s : mensagemEnviada) {
			System.out.print(s);
		}

	}

	private static ArrayList<String> ajusteArray(ArrayList<String> mensagemDigitada) {
		ArrayList<String> novo = new ArrayList<String>();
		for (String string : mensagemDigitada) {
			char[] vetorChar = string.toCharArray();
			for (int i = 0; i < vetorChar.length; i++) {
				String character = Character.toString(vetorChar[i]);
				novo.add(character);
			}
		}
		return novo;
	}
    
}
