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

}
