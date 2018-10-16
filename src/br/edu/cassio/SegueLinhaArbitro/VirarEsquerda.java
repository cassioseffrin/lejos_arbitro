
package br.edu.cassio.SegueLinhaArbitro;

import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

/*
 * Author Cassio Seffrin
 */
public class VirarEsquerda implements Behavior {

	LightSensor sensorEsquerdo;
	LightSensor sensorDireito;
	DifferentialPilot cerebro;

	public VirarEsquerda(LightSensor sensorEsquerdo, LightSensor sensorDireito, DifferentialPilot cerebro) {
		this.sensorEsquerdo = sensorEsquerdo;
		this.sensorDireito = sensorDireito;
		this.cerebro = cerebro;
	}

	public boolean takeControl() {
		return true;
	}

	public void action() {
	}

	public void suppress() {
	}

}
