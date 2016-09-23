/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

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
     
    public String addBinary(String a, String b) {
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
}