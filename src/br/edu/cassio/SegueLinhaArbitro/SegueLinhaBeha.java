package br.edu.cassio.SegueLinhaArbitro;

import br.edu.cassio.util.ConstantesRobo;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * 
 * @author Cassio Seffrin
 */
public class SegueLinhaBeha {

	public static boolean flagVirar = false;

	public static void lightValues(LightSensor esquerda, LightSensor direita) {
		System.out.println(esquerda.getLightValue() + "\t" + direita.getLightValue());
	}

	public static void main(String[] args) {

		DifferentialPilot cerebro = new DifferentialPilot(ConstantesRobo.DIAMETRO_RODA,
				ConstantesRobo.LARGURA_ENTRE_RODAS, ConstantesRobo.motorEsquerdo, ConstantesRobo.motorDireito, true);
		LightSensor esquerda = new LightSensor(SensorPort.S3);
		LightSensor direita = new LightSensor(SensorPort.S4);

		Behavior encontrarLinha = new EncontrarLinha(esquerda, direita, cerebro);
		Behavior avancar = new Avancar(esquerda, direita, cerebro);
		Behavior[] comportamento = { avancar, encontrarLinha };
		Arbitrator arbitro = new Arbitrator(comportamento);
		arbitro.start();
	}

	public static boolean getFlagVirar() {
		return flagVirar;
	}

	public static void setTurnFlag(boolean novaFlag) {
		flagVirar = novaFlag;
	}
}
