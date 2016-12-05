package checksum_crc;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class Checksum_CRC {

    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {ArrayList<String> mensagemDigitada = new ArrayList<String>();
        Binario binario = new Binario();
        Checksum checksum = new Checksum();
        Scanner teclado = new Scanner(System.in);
        Aleatorio aleatorio = new Aleatorio();
        String mensagemAleatoriaGerada,polinomioGerador;
        
        int tamanhoPacotes, pacotesAleatórios,seed;
        double probabilidade;
        System.out.println("Digite o tamanho dos pacotes a serem gerados aleatoriamente: ");
        tamanhoPacotes = teclado.nextInt();
        System.out.println("Digite o número de pacotes aleatórios a serem gerados: ");
        pacotesAleatórios = teclado.nextInt();
        System.out.println("Digite a probabilidade de alteração de cada bit da mensagem: ");
        probabilidade = teclado.nextDouble();
        System.out.println("Digite o valor da seed do gerador de números pseudo-aleatórios: ");
        seed = teclado.nextInt();
        System.out.println("Digite o polinômio gerador (Ex. 121): ");
        teclado.nextLine();
        polinomioGerador = teclado.nextLine();
        
        mensagemAleatoriaGerada = aleatorio.geradorMensagemAleatoria(seed);
        
        
        //Checksum
        SimuladorChecksum simuladorChecksum = new SimuladorChecksum();
        simuladorChecksum.iniciaSimuladorChecksum(tamanhoPacotes, pacotesAleatórios, probabilidade, seed, mensagemAleatoriaGerada);
        
        Thread threadChecksum = new Thread(simuladorChecksum);
        threadChecksum.start();
        threadChecksum.join();
        //Checksum
        
        //CRC
        SimuladorCrc simuladorCrc = new SimuladorCrc();
        simuladorCrc.iniciaSimuladorCrc(tamanhoPacotes, pacotesAleatórios, probabilidade, seed,binario.criaBinarioPolinomioGerador(polinomioGerador), mensagemAleatoriaGerada);
        
        Thread threadCrc = new Thread(simuladorCrc);
        threadCrc.start();
        threadCrc.join();
        //CRC
        
        System.out.println("\nResultado Checksum = " + simuladorChecksum.resultChecksum);
        System.out.println("Contador de colisão (checksum) = " + simuladorChecksum.contColisoes);
        
        System.out.println("\nResultado CRC = " + simuladorCrc.resultCrc);
        System.out.println("Contador de colisão (CRC) = " + simuladorCrc.contColisoes);


        
    }

}
