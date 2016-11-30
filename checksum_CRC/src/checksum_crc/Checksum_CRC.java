/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checksum_crc;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

/**
 *
 * @author kaio.teixeira
 */
public class Checksum_CRC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws UnsupportedEncodingException{
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        ArrayList <String> mensagemDigitada = new ArrayList();
        Binario binario = new Binario();
        Checksum checksum = new Checksum();
        String polinomioGerador;
//        
//        System.out.println("Digite a mensagem:");
//        String mensagemOriginal = teclado.nextLine();
//        binario.converterMensagemParaBinario(mensagemOriginal, mensagemDigitada);
//        System.out.println(mensagemDigitada.get(0));
//        System.out.println(mensagemDigitada.get(1));
//        System.out.println(binario.somaBinario(mensagemDigitada.get(0), mensagemDigitada.get(1)));
//        System.out.println(checksum.checksum(mensagemDigitada,mensagemDigitada.size()));

        Crc crc = new Crc();
        System.out.println("Digite a mensagem:");
        String mensagemOriginal = teclado.nextLine();
        binario.converterMensagemParaBinario(mensagemOriginal, mensagemDigitada);
        System.out.println("Digite o polinomio gerador:");
        polinomioGerador = teclado.nextLine();
        
        ArrayList <String> polinomio = new ArrayList();
        polinomio = binario.criaBinarioPolinomioGerador(polinomioGerador);
         for (String s: polinomio)
		System.out.print(s);
        //crc.crc(mensagemDigitada, mensagemDigitada.size(), polinomioGerador);
        
        
    }
    
}
