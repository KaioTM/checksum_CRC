package model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KaioT
 */
public class Simulador {

    public int tamanhoPacotes, pacotesAleatórios, probabilidade, seed, polinomioGerador;
    String mensagemAleatoriaGerada;
    Scanner teclado = new Scanner(System.in);
    Binario binario = new Binario();
    ArrayList<String> mensagemAleatoriaGeradaEmBinario = new ArrayList<String>();
    
    public void iniciaSimuladorChecksum(int tamanhoPacotes,int pacotesAleatórios, int probabilidade,int seed) {
        
        tamanhoPacotes = teclado.nextInt();
        pacotesAleatórios = teclado.nextInt();
        probabilidade = teclado.nextInt();
        seed = teclado.nextInt(); 
    }
    public void iniciaSimuladorCrc(int tamanhoPacotes,int pacotesAleatórios, int probabilidade,int seed,int polinomioGerador) {
        
        this.tamanhoPacotes = tamanhoPacotes;
        this.pacotesAleatórios = pacotesAleatórios;
        this.probabilidade = probabilidade;
        this.seed = seed;
        this.polinomioGerador = polinomioGerador;
        
    }
    public void armazenaMensagemAleatoriaGerada(String mensagemAleatoriaGerada) throws UnsupportedEncodingException{
        this.mensagemAleatoriaGerada = mensagemAleatoriaGerada;
        binario.converterMensagemParaBinario(mensagemAleatoriaGerada, mensagemAleatoriaGeradaEmBinario);
        
    }

}
