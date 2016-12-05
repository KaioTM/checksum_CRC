package model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kaio.teixeira
 */
public class Aleatorio {

    // Método Responsável por gerar uma mensagem aleatória com base na quantidade de caracteres, passado por parâmetro
    public String geradorMensagemAleatoria(int tamanhoMensagem) {
        Random aleatorio = new Random();
        String caracteres = "abcdefghijklmnopqrstuvxwyzABCDEFGHIJKLMNOPQRSTUVXWYZ123456789";
        char[] text = new char[tamanhoMensagem];
        for (int i = 0; i < tamanhoMensagem; i++) {
            text[i] = caracteres.charAt(aleatorio.nextInt(caracteres.length()));
        }
        return new String(text);
    }

//    public String inserirErrosAleatorios(String sequenciaBits, int tamanho, double p) {
//        Random random = new Random();
//        //p = p * 10;
//        do {
//            for (int i = 0; i < sequenciaBits.length(); i++) {
//                int probabilidade = random.nextInt(1);
//                if (probabilidade <= p) {
//                    char bit = sequenciaBits.charAt(i);
//                    char bitAlterado = bit == '1' ? '0' : '1';
//                    sequenciaBits = substituiBitAlterado(sequenciaBits, bitAlterado, i);
//                    break;
//                }
//            }
//        } while (sequenciaBits.equals(sequenciaBits));
//        return sequenciaBits;
//    }
//
//    private String substituiBitAlterado(String sequenciaBitsAlterada, char bitAlterado, int i) {
//        String novaMensagem = "";
//        for (int j = 0; j < sequenciaBitsAlterada.length(); j++) {
//            if (j == i) {
//                novaMensagem = novaMensagem + bitAlterado;
//            } else {
//                novaMensagem = novaMensagem + sequenciaBitsAlterada.charAt(j);
//            }
//        }
//        return novaMensagem;
//    }
    public ArrayList<String> inserirErrosAleatorios(ArrayList<String> sequenciaBits, int tamanho, double p) {
        Random random = new Random();
        

        double probabilidade;
        ArrayList<String> mensagemAlterada = new ArrayList<>();
        mensagemAlterada = sequenciaBits;
        //p = p * 10;
        for (int k = 0; k < tamanho; k++) {
            String mensagem = mensagemAlterada.get(k);
           
            for (int i = 0; i < mensagem.length(); i++) {
                String novaMensagem = "";
                probabilidade = random.nextInt(100) + 1;
                probabilidade = probabilidade / 100;
                if (probabilidade <= p) {
                    char bit = mensagem.charAt(i);
                    char bitAlterado = (bit == '1') ? '0' : '1';

                    for (int j = 0; j < mensagem.length(); j++) {
                        if (j == i) {
                            novaMensagem += bitAlterado;
                        } else {
                            novaMensagem += mensagem.charAt(j);
                        }
                    }

                    mensagemAlterada.set(k, novaMensagem);
                    mensagem = mensagemAlterada.get(k);
                    
                }

            }

        }

        return mensagemAlterada;
    }

}
