/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KaioT
 */
public class SimuladorChecksum extends Simulador implements Runnable{
    public String resultChecksum;

    @Override
    public void run() {
       Checksum checksum = new Checksum();
       Aleatorio aleatorio = new Aleatorio();
       
       for (int i=0; i<= super.pacotesAleatórios;i++){
            mensagemAleatoriaGerada = aleatorio.geradorMensagemAleatória(seed);
           try {
               super.armazenaMensagemAleatoriaGerada(mensagemAleatoriaGerada);
           } catch (UnsupportedEncodingException ex) {
               Logger.getLogger(SimuladorChecksum.class.getName()).log(Level.SEVERE, null, ex);
           }
            resultChecksum = checksum.checksumEncode(super.mensagemAleatoriaGeradaEmBinario, super.mensagemAleatoriaGeradaEmBinario.size());
          
//Lembrar de incluir a mensagem alterada aleatoriamente na frase abaixo
           if (checksum.validaMensagem(super.mensagemAleatoriaGeradaEmBinario, resultChecksum)== false){
               super.contColisoes++;
           }

        }
    }
}
