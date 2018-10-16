package br.edu.cassio.SegueLinhaArbitro;

import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

/**
 * 
 * @author Cassio Seffrin
 */
public class Avancar implements Behavior {

	public static int PRETO = 45;
	private LightSensor sensorEsquerdo;
	private LightSensor sensorDireito;
	private DifferentialPilot cerebro;

	public Avancar(LightSensor sensorEsquerdo, LightSensor sensorDireito, DifferentialPilot cerebro) {
		this.sensorEsquerdo = sensorEsquerdo;
		this.sensorDireito = sensorDireito;
		this.cerebro = cerebro;
	}

	public boolean takeControl() {
		return sensorEsquerdo.getLightValue() > PRETO && sensorDireito.getLightValue() > PRETO;

	}

	public void action() {
		cerebro.forward();
	}

	public void suppress() {
		cerebro.stop();
	}
}
