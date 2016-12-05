package model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KaioT
 */
public class Simulador {

    public int tamanhoPacotes, pacotesAleatorios,seed;
    double probabilidade;
    String mensagemAleatoriaGerada;
    Scanner teclado = new Scanner(System.in);
    Binario binario = new Binario();
    ArrayList<String> mensagemAleatoriaGeradaEmBinario = new ArrayList<>();
    ArrayList<String> polinomioGerador = new ArrayList<>();
    public int contColisoes;
  
        
    public void iniciaSimuladorChecksum(int tamanhoPacotes,int pacotesAleatórios, double probabilidade,int seed, String mensagemAleatoriaGerada) {
        
        this.tamanhoPacotes = tamanhoPacotes;
        this.pacotesAleatorios = pacotesAleatórios;
        this.probabilidade = probabilidade;
        this.seed = seed;
        this.mensagemAleatoriaGerada = mensagemAleatoriaGerada;
    }
    public void iniciaSimuladorCrc(int tamanhoPacotes,int pacotesAleatórios, double probabilidade,int seed,ArrayList<String> polinomioGerador, String mensagemAleatoriaGerada) {
        
        this.tamanhoPacotes = tamanhoPacotes;
        this.pacotesAleatorios = pacotesAleatórios;
        this.probabilidade = probabilidade;
        this.seed = seed;
        this.polinomioGerador = polinomioGerador;
        this.mensagemAleatoriaGerada = mensagemAleatoriaGerada;
        
    }
    public void armazenaMensagemAleatoriaGerada(String mensagemAleatoriaGerada) throws UnsupportedEncodingException{
        this.mensagemAleatoriaGerada = mensagemAleatoriaGerada;
        binario.converterMensagemParaBinario(mensagemAleatoriaGerada, mensagemAleatoriaGeradaEmBinario);
        
    }
    

}
