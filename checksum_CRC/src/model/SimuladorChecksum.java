/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author KaioT
 */
public class SimuladorChecksum extends Simulador implements Runnable{
    public String resultChecksum;
    @Override
    public void run() {
        Checksum checksum = new Checksum();
        resultChecksum = checksum.checksumEncode(super.mensagemAleatoriaGeradaEmBinario, super.mensagemAleatoriaGeradaEmBinario.size());
    }
}
