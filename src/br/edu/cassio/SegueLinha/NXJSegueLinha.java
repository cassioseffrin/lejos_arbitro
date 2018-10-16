package br.edu.cassio.SegueLinha;

import lejos.nxt.*;
 
/**
 * 
 * @author Cassio
 */

public class NXJSegueLinha extends NXBoot {

    public static void main(String[] args) throws InterruptedException {
        
    
        System.out.println("Programa para seguir linha");
        LightSensor luz = new LightSensor(SensorPort.S1);
        while (!Button.ESCAPE.isPressed()) {
            if (luz.readValue() > 40) {
                avanca(100);
                esquerda(50);
            } else {
                avanca(10);
                direita(10);
            }
        }
    }
}
