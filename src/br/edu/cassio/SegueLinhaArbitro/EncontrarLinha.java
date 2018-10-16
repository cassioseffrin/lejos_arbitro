package br.edu.cassio.SegueLinhaArbitro;

import lejos.nxt.LightSensor;
import lejos.nxt.Sound;
import lejos.robotics.navigation.DifferentialPilot;
//import lejos.robotics.navigation.Pilot;
import lejos.robotics.subsumption.Behavior;

/**
 * 
 * @author Cassio Seffrin
 */
public class EncontrarLinha implements Behavior {

	public static int PRETO = 45;
	private LightSensor sensorEsquerdo;
	private LightSensor sensorDireito;
	private DifferentialPilot cerebro;

	public EncontrarLinha(LightSensor sensorEsquerdo, LightSensor sensorDireito, DifferentialPilot cerebro) {
		this.sensorEsquerdo = sensorEsquerdo;
		this.sensorDireito = sensorDireito;
		this.cerebro = cerebro;
	}

	public boolean takeControl() {
		return sensorEsquerdo.getLightValue() <= PRETO ^ sensorDireito.getLightValue() <= PRETO;
	}

	public void action() {
		/// testing
		// LineFollower.lightValues(sensorEsquerdo, sensorDireito);
		// if sensorEsquerdo on black, stop left wheel

		Sound.playTone(440, 2);
		int angle = 360;
		int turnRate;

		if (sensorEsquerdo.getLightValue() <= PRETO)
			turnRate = 90;
		else
			turnRate = -90;

		cerebro.steer(turnRate, angle, true);
	}

	public void suppress() {
		cerebro.stop();
	}

}
