package model;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KaioT
 */
public class SimuladorChecksum extends Simulador implements Runnable {

    public String resultChecksum;

    @Override
    public void run() {
        Checksum checksum = new Checksum();
        Aleatorio aleatorio = new Aleatorio();

        for (int i = 1; i <= super.pacotesAleatorios; i++) {
            mensagemAleatoriaGerada = aleatorio.geradorMensagemAleatoria(seed);
            try {
                super.armazenaMensagemAleatoriaGerada(mensagemAleatoriaGerada);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(SimuladorChecksum.class.getName()).log(Level.SEVERE, null, ex);
            }
            resultChecksum = checksum.checksumEncode(super.mensagemAleatoriaGeradaEmBinario, super.mensagemAleatoriaGeradaEmBinario.size());

            if (checksum.validaMensagem(aleatorio.inserirErrosAleatorios(mensagemAleatoriaGeradaEmBinario, mensagemAleatoriaGeradaEmBinario.size(), super.probabilidade), resultChecksum) == false) {
                super.contColisoes++;
            }

        }
    }
}
