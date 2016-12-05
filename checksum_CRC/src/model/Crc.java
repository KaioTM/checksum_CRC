package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Crc {

    public ArrayList<String> calculaCrcEnviado(ArrayList<String> mensagemBinario, ArrayList<String> polinomioGerador,
            int grauPolinomioGerador) {
        mensagemBinario = adicionaRBits(mensagemBinario, grauPolinomioGerador);
        return calculaDivisaoEnvio(mensagemBinario, polinomioGerador, grauPolinomioGerador);
    }

    public ArrayList<String> calculaMensagemEnviada(ArrayList<String> mensagemBinario, ArrayList<String> polinomioGerador,
            int grauPolinomioGerador) {
        ArrayList<String> mensagemGeral = new ArrayList<>();
        
        for (int i=0; i< mensagemBinario.get(0).length(); i++){
            char mensagem = mensagemBinario.get(0).charAt(i);
            mensagemGeral.add(new StringBuilder().append(mensagem).toString());
        }
        
        ArrayList<String> mensagemOriginal = mensagemGeral;
        ArrayList<String> crc = calculaCrcEnviado(mensagemBinario, polinomioGerador, grauPolinomioGerador);
        ArrayList<String> mensagemEnviada = adicionaMensagemCrc(mensagemOriginal, crc);

        return mensagemEnviada;
    }

    public boolean calculaMensagemRecebida(ArrayList<String> mensagemBinario, ArrayList<String> polinomioGerador,
            int grauPolinomioGerador) {
        ArrayList<String> mensagemVerificacao = calculaDivisaoReceptor(mensagemBinario, polinomioGerador,
                grauPolinomioGerador);
        return verificaMensagem(mensagemVerificacao);
    }

    public boolean verificaMensagem(ArrayList<String> mensagemVerificacao) {
        for (String string : mensagemVerificacao) {
            if (!string.equals("0")) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> adicionaMensagemCrc(ArrayList<String> mensagemOriginal, ArrayList<String> crc) {
        for (int i = 0; i < crc.size(); i++) {
            mensagemOriginal.add(crc.get(i));
        }
        return mensagemOriginal;
    }

    /**
     *
     * Realiza calculo da divisão
     *
     * @param mensagemBinario
     * @param polinomioGerador
     * @param grauPolinomio TODO
     * @return
     */
    private ArrayList<String> calculaDivisaoEnvio(ArrayList<String> mensagemBinario, ArrayList<String> polinomioGerador,
            int grauPolinomio) {
        ArrayList<String> crc = null;
        int casaDecimalParaDivisao = polinomioGerador.size();
        for (int index = 0; index < mensagemBinario.size(); index++) {
            if (index == 0) {
                crc = calculaXOR(new ArrayList<String>(mensagemBinario.subList(0, casaDecimalParaDivisao)),
                        polinomioGerador);
            } else {
                int elementosRemovidos = 0;
                for (Iterator<String> interator = crc.iterator(); interator.hasNext();) {
                    String elemento = interator.next();
                    if (elemento.equals("0")) {
                        elementosRemovidos++;
                        interator.remove();
                    } else {
                        break;
                    }
                }

                while (elementosRemovidos != 0) {
                    try {
                        crc.add(mensagemBinario.get(casaDecimalParaDivisao));
                        casaDecimalParaDivisao++;
                        elementosRemovidos--;
                    } catch (IndexOutOfBoundsException e) {
                        int tamanhoCrc = grauPolinomio;
                        int j = 0;
                        while (crc.size() < tamanhoCrc) {
                            crc.add(j, "0");
                            j++;
                        }
                        return crc;
                    }
                }
                crc = calculaXOR(crc, polinomioGerador);
            }
        }
        return crc;
    }

    /**
     *
     * Realiza calculo da divisão
     *
     * @param mensagemBinario
     * @param polinomioGerador
     * @param grauPolinomio TODO
     * @return
     */
    public ArrayList<String> calculaDivisaoReceptor(ArrayList<String> mensagemBinario,
            ArrayList<String> polinomioGerador, int grauPolinomio) {
        ArrayList<String> resto = null;
        int casaDecimalParaDivisao = polinomioGerador.size();
        for (int index = 0; index < mensagemBinario.size(); index++) {
            if (index == 0) {
                resto = calculaXOR(new ArrayList<String>(mensagemBinario.subList(0, casaDecimalParaDivisao)),
                        polinomioGerador);
            } else {
                int elementosRemovidos = 0;
                for (Iterator<String> interator = resto.iterator(); interator.hasNext();) {
                    String elemento = interator.next();
                    if (elemento.equals("0")) {
                        elementosRemovidos++;
                        interator.remove();
                    } else {
                        break;
                    }
                }

                while (elementosRemovidos != 0) {
                    try {
                        resto.add(mensagemBinario.get(casaDecimalParaDivisao));
                        casaDecimalParaDivisao++;
                        elementosRemovidos--;
                    } catch (IndexOutOfBoundsException e) {
                        int tamanhoCrc = grauPolinomio;
                        int j = 0;
                        while (resto.size() < tamanhoCrc) {
                            resto.add(j, "0");
                            j++;
                        }
                        return resto;
                    }
                }
                resto = calculaXOR(resto, polinomioGerador);
            }
        }
        return resto;
    }

    /**
     *
     * Adiciona "r" bits 0 ao final da mensagem a ser enviada
     *
     * @param mensagemBinario
     * @param grauPolinomioGerador
     * @return
     */
    private ArrayList<String> adicionaRBits(ArrayList<String> mensagemBinario, int grauPolinomioGerador) {
        while (grauPolinomioGerador != 0) {
            mensagemBinario.add("0");
            grauPolinomioGerador--;
        }
        return mensagemBinario;
    }

    /**
     * Método que realiza a operação lógica de ou exclusivo dentro da divisão
     * dos polinomios
     *
     * @param a
     * @param b
     * @return
     */
    private ArrayList<String> calculaXOR(ArrayList<String> mensagemEnviada, ArrayList<String> polinomioGerador) {
        ArrayList<String> resultado = new ArrayList<String>();
        for (int i = 0; i < mensagemEnviada.size(); i++) {
            if (mensagemEnviada.get(i).equals(polinomioGerador.get(i))) {
                resultado.add("0");
            } else {
                resultado.add("1");
            }
        }
        return resultado;
    }

}
