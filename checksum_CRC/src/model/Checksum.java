package model;

import java.util.ArrayList;

/**
 *
 * @author kaio.teixeira
 */
public class Checksum {

    public String checksumEncode(ArrayList<String> mensagemDigitada, int tamanhoMensagem) {
        int i;
        String parcial1 = "00000000";
        String parcial2 = "00000000";
        String checksum;
        String soma = "0";

        Binario binario = new Binario();
        for (i = 0; i <= tamanhoMensagem;) {
            if (i < tamanhoMensagem) {
                if (tamanhoMensagem == 1) {
//                    System.out.println("A(" + i + ") = " + mensagemDigitada.get(i));
                    parcial2 = mensagemDigitada.get(0);
                    checksum = binario.somaBinario(parcial2, parcial1);
                    checksum = checksum.replace('0', '2').replace('1', '0').replace('2', '1');
                    return checksum;
                } else if (soma.equals("0")) {
//                    System.out.println("A(" + (i + 1) + ") = " + mensagemDigitada.get(i + 1));
//                    System.out.println("A(" + i + ") = " + mensagemDigitada.get(i));
                    parcial1 = mensagemDigitada.get(i + 1);
                    parcial2 = mensagemDigitada.get(i);
                    soma = binario.somaBinario(parcial1, parcial2);
                    if (soma.length() == 9) {
                        soma = binario.somaBinario(Character.toString(soma.charAt(0)), soma);
                    }
                    i = i + 2;
                } else {
//                    System.out.println("Soma = " + soma);
//                    System.out.println("A(" + i + ") = " + mensagemDigitada.get(i));
                    parcial1 = soma;
                    parcial2 = mensagemDigitada.get(i);
                    soma = binario.somaBinario(parcial1, parcial2);
                    if (soma.length() == 9) {
                        soma = binario.somaBinario(Character.toString(soma.charAt(0)), soma);
                        StringBuilder sb = new StringBuilder(soma);
                        sb.deleteCharAt(0);
                        soma = sb.toString();
                    }
                    i = i + 1;
                }
            } else {
                checksum = soma;
                checksum = checksum.replace('0', '2').replace('1', '0').replace('2', '1');
                return checksum;
        }
        }
        checksum = soma;
        checksum = checksum.replace('0', '2').replace('1', '0').replace('2', '1');
        return checksum;
    }

    //Método realiza novamente o checksum e compara com o checksum enviado para ver se houve mudança na mensagem
    public boolean validaMensagem(ArrayList<String> mensagemDigitada, String checksumEnviado) {
        String checksumValidador = checksumEncode(mensagemDigitada, mensagemDigitada.size());
        System.out.println("Checksum recebido: "+ checksumValidador );
        
        return checksumValidador.equals(checksumEnviado);

    }
}
