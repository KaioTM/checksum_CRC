/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KaioT
 */
public class SimuladorCrc extends Simulador implements Runnable {

    public ArrayList<String> resultCrc;

    @Override
    public void run() {
        Crc crc = new Crc();
        Aleatorio aleatorio = new Aleatorio();

        for (int i = 0; i < super.pacotesAleatorios; i++) {
            mensagemAleatoriaGerada = aleatorio.geradorMensagemAleatoria(seed);
            try {
                super.armazenaMensagemAleatoriaGerada(mensagemAleatoriaGerada);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(SimuladorChecksum.class.getName()).log(Level.SEVERE, null, ex);
            }
            resultCrc = crc.calculaMensagemEnviada(super.mensagemAleatoriaGeradaEmBinario, super.polinomioGerador, 8);

            if (!crc.verificaMensagem(crc.calculaDivisaoReceptor(resultCrc, super.polinomioGerador, 8))) {
                super.contColisoes++;
            }

        }
    }

}
