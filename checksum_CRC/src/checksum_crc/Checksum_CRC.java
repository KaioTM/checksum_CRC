/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checksum_crc;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
    public static void main(String[] args) throws UnsupportedEncodingException {
        // TODO code application logic here
        ArrayList <Integer> mensagemBinaria = new ArrayList();
        byte[] infoBin;
        infoBin = "this is plain text".getBytes("UTF-8");
        for (byte b : infoBin) {
            mensagemBinaria.add(Integer.parseInt(String.format("%08d",Integer.parseInt(Integer.toBinaryString(b)), 2)));
            
        }
        System.out.println(mensagemBinaria.get(2));
    }
    
}
