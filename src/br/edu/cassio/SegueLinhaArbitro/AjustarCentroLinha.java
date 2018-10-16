
package br.edu.cassio.SegueLinhaArbitro;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

/*
 * Author Cassio Seffrin
 */
public class AjustarCentroLinha implements Behavior {

	LightSensor sensorEsquerdo;
	LightSensor sensorDireito;

	public AjustarCentroLinha(LightSensor sensorEsquerdo, LightSensor sensorDireito) {
		this.sensorEsquerdo = sensorEsquerdo;
		this.sensorDireito = sensorDireito;
	}

	public boolean takeControl() {
		return (sensorEsquerdo.getLightValue() < JuncaoDetectada.PRETO
				^ sensorDireito.getLightValue() < JuncaoDetectada.PRETO);
	}

	public void action() {

		Motor.A.backward();
		Motor.B.backward();

		if (sensorEsquerdo.getLightValue() < JuncaoDetectada.PRETO) {
			while (sensorEsquerdo.getLightValue() < 40) {
				Motor.B.setSpeed(Motor.B.getSpeed() - 60);
				try {
					Thread.sleep(10);
				} catch (InterruptedException ex) {
					System.out.println("Exception occurred");
				}
			}
		} else {
			while (sensorDireito.getLightValue() < 40) {
				Motor.A.setSpeed(Motor.A.getSpeed() - 60);
				try {
					Thread.sleep(10);
				} catch (InterruptedException ex) {
					System.out.println("Exception occurred");
				}
			}
		}
	}

	public void suppress() {
		Motor.A.stop();
		Motor.B.stop();
	}
}
