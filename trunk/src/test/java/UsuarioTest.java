/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.softsimphony.checadorgdf.model.Usuario;
import com.softsimphony.checadorgdf.services.UsuarioService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ss
 */
public class UsuarioTest {
    
    public UsuarioTest() {
    }
    
    @Test
    public void test(){
        
        try {
            UsuarioService us=new UsuarioService();
            Usuario usr=new Usuario();
           /* usr.setNombre("Aaron");
            usr.setaPaterno("Araujo");
            usr.setaMaterno("Ruiz");
            usr.setHuellaDigital("");
            usr.setIdArea(1);
            usr.setIdHorario(1);
            System.out.println("Id Obtenido: "+us.insertar(usr));*/
            usr = us.obtener(2);
            System.out.println("Nombre: "+ usr.getNombre());
            System.out.println("A Paterno: "+usr.getaPaterno());
            
            usr.setNombre("Aaron Ariel");
            us.actualizar(usr);
            usr = us.obtener(usr.getIdUsuario());
            System.out.println("Nombre: "+ usr.getNombre());
            System.out.println("A Paterno: "+usr.getaPaterno());
            
            us.eliminar(usr.getIdUsuario());
            usr = us.obtener(usr.getIdUsuario());
            
            if(usr == null)
                System.out.println("Se ha eliminado el registro");
            else
                System.out.println("No se pudo eliminar el registro");
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(UsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
