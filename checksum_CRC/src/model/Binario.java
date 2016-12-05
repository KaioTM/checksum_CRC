package model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

public class Binario {

    //Método responsável por gerar um número binário (0 ou 1) aleatório.
    public int geraNumeroBinarioAleatorio() {
        Random binario = new Random();
        return binario.nextInt(2);
    }
    //Converte a mensagem original para um conjunto de 1 byte (8 bits) por caractere em cada posição do ArrayList. 

    public void converterMensagemParaBinario(String mensagemOriginal, ArrayList<String> mensagemBinaria) throws UnsupportedEncodingException {
        byte[] infoBin;
        infoBin = mensagemOriginal.getBytes("UTF-8");
        for (byte b : infoBin) {
            mensagemBinaria.add(String.format("%08d", Integer.parseInt(Integer.toBinaryString(b)), 2));
        }
    }

    // Soma os binários de 2 strings passadas por parâmetro.
    public String somaBinario(String a, String b) {

        int la = a.length();
        int lb = b.length();

        int max = Math.max(la, lb);

        StringBuilder sum = new StringBuilder("");
        int carry = 0;

        for (int i = 0; i < max; i++) {
            int m = getBit(a, la - i - 1);
            int n = getBit(b, lb - i - 1);
            int add = m + n + carry;
            sum.append(add % 2);
            carry = add / 2;
        }

        if (carry == 1) {
            sum.append("1");
        }

        return sum.reverse().toString();

    }

    //Método responsável por identificar se o número binário é 1 ou 0
    public int getBit(String s, int index) {
        if (index < 0 || index >= s.length()) {
            return 0;
        }

        if (s.charAt(index) == '0') {
            return 0;
        } else {
            return 1;
        }

    }

    // Método responsável 
    public ArrayList<String> criaBinarioPolinomioGerador(String polinomioGeradorDigitadoHexa) {

        ArrayList<String> binarioPolinomio = new ArrayList();
        
        String binarioPolinomioString = String.format("%09d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(polinomioGeradorDigitadoHexa,16))));
        for (int i = 0; i< binarioPolinomioString.length();i++ ){
            binarioPolinomio.add(new StringBuilder().append(binarioPolinomioString.charAt(i)).toString());
        }
        
        return binarioPolinomio;
    }
}
