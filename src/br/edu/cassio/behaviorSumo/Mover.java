package br.edu.cassio.behaviorSumo;

import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

/*
 * @author cassioseffrin
 */
public abstract class Mover implements Behavior {

    /**
     * Compensar a sujeira do sensor de ultrasom.
     */
    public final static int LIMITE_ERRO = 3;

    /**
     * Piloto usado para mover o robo
     */
    protected DifferentialPilot cerebro;

    protected UltrasonicSensor ultrasonic;
    
    protected ColorSensor luz;

    /**
     * Distancia mantria +/- limite erro
     */
    protected int distance;

    /**
     * Construtor
     *
     * @param distance a manter
     * @param cerebro cerebroo
     * @param ultrasonic sensor distancia
     */
    public Mover(int distance, DifferentialPilot cerebro, ColorSensor luz, UltrasonicSensor ultrasonic) {
        this.cerebro = cerebro;
        this.ultrasonic = ultrasonic;
        this.distance = distance;
        this.luz=luz;

    }

    /**
     * parar
     */
    public void suppress() {
        System.out.println("SUPPRESS");
        cerebro.stop();
        Thread.yield();
    }

}
