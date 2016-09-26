/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checksum_crc;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Binario;
import model.Checksum;

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
        
        System.out.println("Digite a mensagem:");
        String mensagemOriginal = teclado.nextLine();
        binario.converterMensagemParaBinario(mensagemOriginal, mensagemDigitada);
       checksum.checksum(mensagemDigitada);
        
        
    }
    
}
