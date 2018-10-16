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

    public static boolean turnFlag = false;

    public static void lightValues(LightSensor left, LightSensor right) {
        System.out.println(left.getLightValue() + "\t" + right.getLightValue());
    }

    public static void main(String[] args) {

    	DifferentialPilot cerebro = new DifferentialPilot(ConstantesRobo.DIAMETRO_RODA,
                                     ConstantesRobo.LARGURA_ENTRE_RODAS,
                                     ConstantesRobo.motorEsquerdo,
                                     ConstantesRobo.motorDireito,
                                     true);
        LightSensor left = new LightSensor(SensorPort.S3);
        LightSensor right = new LightSensor(SensorPort.S4);

        Behavior findLine = new EncontrarLinha(left, right, cerebro);
        Behavior forward = new Avancar(left, right, cerebro);
        Behavior[] bs = {forward, findLine};
        Arbitrator arr = new Arbitrator(bs);
        arr.start();
    }

    public static boolean getTurnFlag() {
        return turnFlag;
    }

    public static void setTurnFlag(boolean newFlag) {
        turnFlag = newFlag;
    }
}
