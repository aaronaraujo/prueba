/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.digitalpersona.uareu.Fmd;
import com.digitalpersona.uareu.UareUException;
import com.softsimphony.checadorgdf.util.LectorUareU;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ss
 */
public class LectorTest {
    
    public LectorTest() {
    }
    
    @Test
    public void test(){
        
        try {
            
            System.out.println("_______________________________________________");
            System.out.println("API U are U Java");
            System.out.println("by Aaron A. Araujo");
            System.out.println("_______________________________________________");
            LectorUareU lector=new LectorUareU();
            
            
            /**
             * Enrrolamiento
             */
            Fmd huella[] = new Fmd[4];
            System.out.println("");
            for(int i=0;i<4;i++){
                System.out.println("[ SYS ] Coloque su huella, intento "+ (i+1));
                huella[i]=lector.obtenerFormatoFmd(lector.capturarHuella());
            }
            
            Fmd huellaEnrrolada= lector.obtenerFormatoEnrrolamiento(huella);
            System.out.println("[ SYS ] Enrrolamiento correcto :)");
            
            System.out.println("[ SYS ] Validacion:");
            while(true){
                
                System.out.println("[ SYS ] Coloque su huella para validarla: ");
                if(lector.validarHuellas(huellaEnrrolada, lector.obtenerFormatoFmd(lector.capturarHuella()))){
                    System.out.println("[ SYS ] Huella Valida :)");
                }else{
                    System.out.println("[ SYS ] Huella Invalida :(");
                }
                
            }
            
        } catch (UareUException ex) {
            Logger.getLogger(LectorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
