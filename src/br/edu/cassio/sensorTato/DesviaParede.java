package br.edu.cassio.sensorTato;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 *
 * @author Cassio Seffrin
 */
public class DesviaParede {

    /**
     * move o robo ateh achar a parede, quando o sensor toca-la, o robo vota um
     * pouco e gira 90 graus e segue em frente novamente
     *
     * @param args
     */
    public static void main(String[] args) {
        TouchSensor touch = new TouchSensor(SensorPort.S4);
        DifferentialPilot cerebro = new DifferentialPilot(30, 70f, Motor.A, Motor.C);
        modificaVelocidade(200);
        while (true) {
            if (touch.isPressed()) {
                modificaAceleracao(10);
                cerebro.travel(-100);
                cerebro.rotate(90);
            } else {
                modificaVelocidade(200);
                cerebro.forward();
                System.out.println("velocidade"+Motor.A.getSpeed());
                System.out.println("Tacho a: " + Motor.A.getTachoCount());
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