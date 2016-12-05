/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author kaio.teixeira
 */
public class Aleatorio {

    // Método Responsável por gerar uma mensagem aleatória com base na quantidade de caracteres, passado por parâmetro
    public String geradorMensagemAleatória(int tamanhoMensagem) {
        Random aleatorio = new Random();
        String caracteres = "abcdefghijklmnopqrstuvxwyzABCDEFGHIJKLMNOPQRSTUVXWYZ123456789";
        char[] text = new char[tamanhoMensagem];
        for (int i = 0; i < tamanhoMensagem; i++) {
            text[i] = caracteres.charAt(aleatorio.nextInt(caracteres.length()));
        }
        return new String(text);
    }
    
    public String inserirErrosAleatorios(String sequenciaBits, int tamanho, double p) {
		Random random = new Random();
		//p = p * 10;
		do {
			for (int i = 0; i < sequenciaBits.length(); i++) {
				int probabilidade = random.nextInt(1);
				if (probabilidade <= p) {
					char bit = sequenciaBits.charAt(i);
					char bitAlterado = bit == '1' ? '0' : '1';
					sequenciaBits = substituiBitAlterado(sequenciaBits, bitAlterado, i);
					break;
				}
			}
		} while (sequenciaBits == sequenciaBits);
		return sequenciaBits;
	}

	private String substituiBitAlterado(String sequenciaBitsAlterada, char bitAlterado, int i) {
		String novaMensagem = "";
		for (int j = 0; j < sequenciaBitsAlterada.length(); j++) {
			if (j == i) {
				novaMensagem = novaMensagem + bitAlterado;
			} else {
				novaMensagem = novaMensagem + sequenciaBitsAlterada.charAt(j);
			}
		}
		return novaMensagem;
	}

}
