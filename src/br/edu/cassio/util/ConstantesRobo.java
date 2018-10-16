package br.edu.cassio.util;

import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;

/**
 *
 * @author cassioseffrin
 */
public class ConstantesRobo {

    /**
     * distancia objeto detectado em cm
     */
    public static final float MAXIMA_DISTANCIA_SENSOR = 10;
    /**
     * diametro roda em mm.
     */
    public static final float DIAMETRO_RODA = 40f;
    /**
     * distancia entre o centro e cada roda em mm.
     */
    public static final float LARGURA_ENTRE_RODAS = 80f;
    /**
     * uma volta completa roda com base no diametro da roda.
     */
    public static final float ROTACAO_360 = (float) Math.PI * DIAMETRO_RODA;
    /**
     * motor esquerdo.
     */
    public static final NXTRegulatedMotor motorEsquerdo = Motor.C;
    /**
     * motor direito.
     */
    public static final NXTRegulatedMotor motorDireito = Motor.A;
}
