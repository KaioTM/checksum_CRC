/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author kaio.teixeira
 */
public class Crc {
     public String crc(ArrayList<String> mensagemDigitada, int tamanhoMensagem,String polinomioGerador){ 
        String crc ="0";
        Binario binario = new Binario();
        return crc;
     }
     public ArrayList <String> criaBinarioPolinomioGerador (String polinomioGeradorDigitado){
         ArrayList <String> binarioPolinomio = new ArrayList();
         String caracteres = " #@_\\/.*+Xx";
         String[] teste;
         teste = polinomioGeradorDigitado.split("[" + Pattern.quote(caracteres) + "]");
         
         
         return binarioPolinomio;
     }
}
