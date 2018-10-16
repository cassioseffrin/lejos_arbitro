package br.edu.cassio.SegueLinha;

import br.edu.cassio.util.ConstantesRobo;
import lejos.nxt.Motor;


/**
 * 
 * @author cassioseffrin
 */
public class NXBoot {
    
    public static void avanca(int ms) throws InterruptedException{
        
        ConstantesRobo.motorDireito.forward();
        ConstantesRobo.motorEsquerdo.forward();
        
        Thread.sleep(ms);
    }
    
    
    public static void voltar(int ms) throws InterruptedException{
        
        ConstantesRobo.motorDireito.backward();
        ConstantesRobo.motorEsquerdo.backward();
        Thread.sleep(ms);
    }
    public static void esquerda(int ms) throws InterruptedException{
        
        ConstantesRobo.motorDireito.forward();
        ConstantesRobo.motorEsquerdo.stop();
        Thread.sleep(ms);
    }
    
    public static void direita(int ms) throws InterruptedException{
        
        ConstantesRobo.motorDireito.stop();
        ConstantesRobo.motorEsquerdo.forward();
        Thread.sleep(ms);
    }
    
    public static void parar() throws InterruptedException{
        ConstantesRobo.motorDireito.stop();
        ConstantesRobo.motorEsquerdo.stop();
    }
    
        public static void modificaVelocidade(int velo) {
        ConstantesRobo.motorDireito.setSpeed(velo);
        ConstantesRobo.motorEsquerdo.setSpeed(velo);
    }

    public static void modificaAceleracao(int aceleracao) {
        ConstantesRobo.motorDireito.setAcceleration(aceleracao);
        ConstantesRobo.motorEsquerdo.setAcceleration(aceleracao);
        
    }
}
