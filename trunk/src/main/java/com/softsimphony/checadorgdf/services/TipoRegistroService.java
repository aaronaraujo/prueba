/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsimphony.checadorgdf.services;

import com.softsimphony.checadorgdf.dao.TiporegistroMapper;
import com.softsimphony.checadorgdf.db.AccesoChecadorGDF_BD;
import com.softsimphony.checadorgdf.model.Tiporegistro;
import com.softsimphony.checadorgdf.model.TiporegistroExample;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author ss
 */
public class TipoRegistroService {
    
    
    private TiporegistroMapper tiporegistroMapper;
    
    public TipoRegistroService(){
        
    }
    
    public Tiporegistro obtenerRegistro(int idTipoRegistro) throws IOException{
        
        SqlSession session=null;
        
        try{
            session = AccesoChecadorGDF_BD.obtenerConexion();
            tiporegistroMapper = session.getMapper(TiporegistroMapper.class);
            return tiporegistroMapper.selectByPrimaryKey(idTipoRegistro);
            
        }finally{
            if(session != null)
                session.close();
        }
        
    }
    
    
    private List<Tiporegistro> ejecutarExample(TiporegistroExample tiporegistroExample) throws IOException{
        List<Tiporegistro> registros;
        SqlSession session=null;
        
        try{
            session = AccesoChecadorGDF_BD.obtenerConexion();
            tiporegistroMapper = session.getMapper(TiporegistroMapper.class);
            registros = tiporegistroMapper.selectByExample(tiporegistroExample);
        }finally{
            if(session != null)
                session.close();
        }
        
        return registros;
    }
    
    public static void main(String[] args) {
        try {
            TipoRegistroService t=new TipoRegistroService();
            
            Tiporegistro registro=t.obtenerRegistro(1);
            System.out.println("Registro:");
            System.out.println("Nombre: "+registro.getNombre());
            
        } catch (IOException ex) {
            Logger.getLogger(TipoRegistroService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
