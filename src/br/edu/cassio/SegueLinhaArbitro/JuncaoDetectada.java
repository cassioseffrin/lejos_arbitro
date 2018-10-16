package br.edu.cassio.SegueLinhaArbitro;

import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

/**
 * @author Cassio Seffrin
 */
public class JuncaoDetectada implements Behavior {

    public static int PRETO = 40;
    private LightSensor sensorEsquerdo;
    private LightSensor sensorDireito;
    private DifferentialPilot cerebro;

	public JuncaoDetectada(LightSensor sensorEsquerdo, LightSensor sensorDireito, DifferentialPilot cerebro) {
        this.sensorEsquerdo = sensorEsquerdo;
        this.sensorDireito = sensorDireito;
        this.cerebro = cerebro;
    }

    public boolean takeControl() {
        return (sensorEsquerdo.getLightValue() <= PRETO
               && sensorDireito.getLightValue() <= PRETO
               && SegueLinhaBeha.getFlagVirar());
    }

    public void action() {
        cerebro.stop();
    }

    public void suppress() {
        cerebro.stop();
    }

}
