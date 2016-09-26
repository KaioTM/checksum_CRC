/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.lang.*;
/**
 *
 * @author kaio.teixeira
 */
public class Checksum {
    public String checksum(ArrayList<String> mensagemDigitada){
        
        String parcial1="00000000";
        String parcial2="00000000";
        String checksum="00000000";
        String soma="00000000";
        Binario binario = new Binario();
//        
//        //Valor parcial dos bits 2 e 1
//        System.out.println(mensagemDigitada.get(1)+" "+ mensagemDigitada.get(0));
//        //Valor parcial dos bits 4 e 3
//        System.out.println(mensagemDigitada.get(3)+" "+ mensagemDigitada.get(2));
        
            for (int i=1;i<=mensagemDigitada.size();){
                if (mensagemDigitada.size()== 1){
                    parcial2=mensagemDigitada.get(0);
                    soma = parcial1 + " " + parcial2;
                    checksum = soma;
                    checksum = checksum.replace('0', '2').replace('1', '0').replace('2', '1');
                    return checksum;
                }else{
                    if(mensagemDigitada.size()== 2){
                        parcial1 = mensagemDigitada.get(1);
                        parcial2 = mensagemDigitada.get(0);
                        soma = parcial1 + " " + parcial2;
                        checksum = soma;
                        checksum = checksum.replace('0', '2').replace('1', '0').replace('2', '1');
                        return checksum;
                    }else{
                        try{
                            
                            
                        }
                        catch (IndexOutOfBoundsException ex){
                            
                        }
                        
                    }
                }
                
//                else{
//                    parcial1 = binario.somaBinario(mensagemDigitada.get(i+1), mensagemDigitada.get(i));
//                    parcial2 = binario.somaBinario(mensagemDigitada.get(i+3), mensagemDigitada.get(i+2));
//                }
                i=i+2;
            
            }
            return checksum;
    }
}