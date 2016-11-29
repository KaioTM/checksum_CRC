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

    public String crc(ArrayList<String> mensagemDigitada, int tamanhoMensagem, String polinomioGerador) {
        String crc = "0";
        Binario binario = new Binario();
        return crc;
    }

    public ArrayList<String> criaBinarioPolinomioGerador(String polinomioGeradorDigitado) {
        ArrayList<String> binarioPolinomio = new ArrayList();
        String caracteres = " #@_\\/.*+";
        String[] fatores;
        fatores = polinomioGeradorDigitado.split("[" + Pattern.quote(caracteres) + "]");
        
        for (int i = 0; i <= 8;++i) {
            try{
            if (fatores[i].contains("X^")) {
                fatores[i] = fatores[i].replace("X^", "");
                int fator = Integer.parseInt(fatores[i]);
                //Parte Responsável por transformar os fatores do polinômio em binário
                for (int n = 0; n <= (8 - fator); n++) {
                    if (n == (8 - fator)) {
                        binarioPolinomio.add((8 - fator), "1");
                        break;
                    }else {
                        try {
                            binarioPolinomio.get(n);
                        } catch (IndexOutOfBoundsException e) {
                            binarioPolinomio.add(n, "0");
                        }
                    }  
                }
            }else if(fatores[i].contains("X")){
                int fator = 7;
                for (int n = 0; n <= fator; n++) {
                    if (n == fator) {
                        binarioPolinomio.add(7,"1");
                        break;
                    }else {
                        try {
                            binarioPolinomio.get(n);
                        } catch (IndexOutOfBoundsException e) {
                            binarioPolinomio.add(n, "0");
                        }
                    }  
                }  
            }else if (fatores[i].contains("1")){   
               int fator = 8;
                for (int n = 0; n <= fator; n++) {
                    if (n == fator) {
                        binarioPolinomio.add(8,"1");
                        break;
                    }else {
                        try {
                            binarioPolinomio.get(n);
                        } catch (IndexOutOfBoundsException e) {
                            binarioPolinomio.add(n, "0");
                        }
                    }  
                }  
            }
                       
        
    }
            catch (ArrayIndexOutOfBoundsException c){
                try{
                    if(binarioPolinomio.get(8).isEmpty() == false){
                    break;
                    }
                }
                catch (IndexOutOfBoundsException c2){
                    binarioPolinomio.add(i, "0");
                }
                
                    
            }
                
                
            }
        
        return binarioPolinomio;
    }
}