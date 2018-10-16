package br.edu.cassio.behaviorSumo;

import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Calcula a distancia e para
 *
 *
 * @author cassioseffrin
 */
public class Parar extends Mover {

    public Parar(int distance, DifferentialPilot cerebro, ColorSensor luz, UltrasonicSensor ultrasonic) {
        super(distance, cerebro, luz, ultrasonic);
    }

    /**
     * decide se o behavior deve pegar o controle
     */
    @Override
    public boolean takeControl() {

        //  System.out.println("PARAR");
        boolean retorno = false;

        if (luz.getLightValue() > 50) {
            retorno = true;
        }
 
        return retorno;
    }

    @Override
    public void action() {
        System.out.println("PARAR");
        cerebro.stop();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {

        }
    }
}
