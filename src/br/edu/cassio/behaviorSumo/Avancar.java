package br.edu.cassio.behaviorSumo;
 
import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 *
 * @author cassioseffrin
 */
public class Avancar extends Mover {

    public Avancar(int distance, DifferentialPilot cerebro, ColorSensor luz, UltrasonicSensor ultrasonic) {
        super(distance, cerebro, luz, ultrasonic);
    }

    /**
     * define o comportamento de controle
     */
    @Override
    public boolean takeControl() {
        boolean  retorno;
        retorno = (ultrasonic.getDistance()  <= 15);
        System.out.println("dist: "+ultrasonic.getDistance() +"ret " +retorno);
        return retorno ;

    }

    /**
     * Move o robo pra frente enquanto condicao de controle for true.
     */
    @Override
    public void action() {
    System.out.println("AVANCAR");
        cerebro.setTravelSpeed(200);
        cerebro.forward();
        while (cerebro.isMoving())
            Thread.yield();
  
    }
}
