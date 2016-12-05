package model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KaioT
 */
public class Simulador {

    public int tamanhoPacotes, pacotesAleatórios,seed, polinomioGerador;
    double probabilidade;
    String mensagemAleatoriaGerada;
    Scanner teclado = new Scanner(System.in);
    Binario binario = new Binario();
    ArrayList<String> mensagemAleatoriaGeradaEmBinario = new ArrayList<String>();
    public int contColisoes;

        
    public void iniciaSimuladorChecksum(int tamanhoPacotes,int pacotesAleatórios, double probabilidade,int seed) {
        
        this.tamanhoPacotes = tamanhoPacotes;
        this.pacotesAleatórios = pacotesAleatórios;
        this.probabilidade = probabilidade;
        this.seed = seed;
    }
    public void iniciaSimuladorCrc(int tamanhoPacotes,int pacotesAleatórios, double probabilidade,int seed,int polinomioGerador) {
        
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
