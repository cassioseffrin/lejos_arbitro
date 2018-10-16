package br.edu.cassio.behaviorSumo;

import br.edu.cassio.util.ConstantesRobo;
import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;


/**
 * 
 * @author cassioseffrin
 */
public class IvarTheBoneless {

 
    public static void main(String [] args) {
        DifferentialPilot cerebro = new DifferentialPilot(ConstantesRobo.DIAMETRO_RODA,
                                     ConstantesRobo.LARGURA_ENTRE_RODAS, Motor.B,
                                     Motor.A, true);
        UltrasonicSensor ultrasonic = new UltrasonicSensor(SensorPort.S3);
        ColorSensor luz = new ColorSensor(SensorPort.S2);
        int distance = 15;
       
cerebro.setTravelSpeed(400);
        //para fechar
        Button.ENTER.addButtonListener(new ButtonListener() {
            public void buttonPressed(Button button) { System.exit(0); }
            public void buttonReleased(Button button) {}
        });

        // cria os comportamentos e adiciona ao array
        Mover avanca = new Avancar(distance, cerebro, luz, ultrasonic);
        Mover girar = new Girar(distance, cerebro, luz, ultrasonic);
        Mover volta = new Voltar(distance, cerebro, luz, ultrasonic);
        Mover para = new Parar(distance, cerebro, luz, ultrasonic);
        Behavior[] moves = {avanca, girar, para};//cia o arbitrator com array de comporatamento 
        // ciclos de comportamento 
        Arbitrator arb = new Arbitrator(moves);
        arb.start();
    }
}