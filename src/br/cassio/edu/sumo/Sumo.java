package br.cassio.edu.sumo;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 *
 * @author Cassio Seffrin
 */
public class Sumo {

    /**
     * move o robo ateh achar a parede, quando o sensor toca-la, o robo vota um
     * pouco e gira 90 graus e segue em frente novamente
     *
     * @param args
     */
    public static void main(String[] args) {
        LightSensor luz = new LightSensor(SensorPort.S1);
        TouchSensor touch = new TouchSensor(SensorPort.S4);
        UltrasonicSensor us = new UltrasonicSensor(SensorPort.S2);
        
        DifferentialPilot cerebro = new DifferentialPilot(30, 70f, Motor.A, Motor.C);
        modificaVelocidade(200);
        
        
         
        while (true) {
            if (us.getDistance()>10) {
                modificaAceleracao(10);
                modificaVelocidade(200);
                cerebro.travel(300);
            } else {
                cerebro.rotate(1);
                modificaVelocidade(200);
                  System.out.println("velocidade"+Motor.A.getSpeed());
                System.out.println("Tacho a: " + Motor.A.getTachoCount());
            }
            //achou linha preta
            if (luz.readValue()>40){
                cerebro.travel(50);
            }
            
            //detectou botao do sensor touch pressionado
            if (touch.isPressed()) {
           
                cerebro.travel(100);
            }
            
        }
    }

    public static void modificaVelocidade(float velo) {
        Motor.A.setSpeed(velo);
        Motor.C.setSpeed(velo);
    }

    public static void modificaAceleracao(int aceleracao) {
        Motor.A.setAcceleration(aceleracao);
        Motor.C.setAcceleration(aceleracao);
    }
}