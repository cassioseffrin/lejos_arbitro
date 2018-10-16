package br.edu.cassio.SegueLinhaArbitro;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

/**
 * 
 * @author Cassio Seffrin
 */
public class TesteSensores {

	public static void main(String[] args) throws InterruptedException {
		LightSensor sensorEsquerdo = new LightSensor(SensorPort.S1);
		LightSensor sensorDireito = new LightSensor(SensorPort.S4);

		while (true) {
			System.out.println("esquerda: " + sensorEsquerdo.getLightValue());
			System.out.println("direita: " + sensorDireito.getLightValue());

			if (sensorEsquerdo.getLightValue() < 45 && sensorDireito.getLightValue() < 45) {
				Motor.A.stop();

				Thread.sleep(1245);

			} else if (sensorEsquerdo.getLightValue() < 45) {
				Motor.C.stop();
			} else if (sensorDireito.getLightValue() < 45) {
				Motor.A.stop();
			} else {
				Motor.A.backward();
				Motor.C.backward();
			}
		}
	}
}
