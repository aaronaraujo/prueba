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
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author ss
 */
public class TiporegistroService {
    
    private TiporegistroMapper tiporegistroMapper;
    
    public TiporegistroService(){
        
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
    
    public List<Tiporegistro> obtenerTodos() throws IOException{
        TiporegistroExample tipoRegistroExample = new TiporegistroExample();
        tipoRegistroExample.createCriteria().andIdTipoRegistroIsNotNull();
        return ejecutarExample(tipoRegistroExample);
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
    
}
