/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author kaio.teixeira
 */
public class Binario {
    
     public int geraNumeroAleatorio(){
        Random binario = new Random();
        return binario.nextInt(2);
    }
     
}
