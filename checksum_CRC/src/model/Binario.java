/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

/**
 *
 * @author kaio.teixeira
 */
public class Binario {
    
     public int geraNumeroBinarioAleatorio(){
        Random binario = new Random();
        return binario.nextInt(2);
    }
     public void converterMensagemParaBinario(String mensagemOriginal, ArrayList <String> mensagemBinaria)throws UnsupportedEncodingException{
        byte[] infoBin;
        infoBin = mensagemOriginal.getBytes("UTF-8");
        for (byte b : infoBin) {
            mensagemBinaria.add(String.format("%08d",Integer.parseInt(Integer.toBinaryString(b)), 2));
        }
     }
     
    public String somaBinario(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int la = a.length();
        int lb = b.length();
        
        int max = Math.max(la, lb);
        
        StringBuilder sum = new StringBuilder("");
        int carry = 0;
        
        for(int i = 0; i < max; i++){
            int m = getBit(a, la - i - 1);
            int n = getBit(b, lb - i - 1);
            int add = m + n + carry;
            sum.append(add % 2);
            carry = add / 2;
        }
        
        if(carry == 1)
            sum.append("1");
        
        return sum.reverse().toString();
        
    }
    
    public int getBit(String s, int index){
        if(index < 0 || index >= s.length())
            return 0;
        
        if(s.charAt(index) == '0')
            return 0;
        else
            return 1;
        
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