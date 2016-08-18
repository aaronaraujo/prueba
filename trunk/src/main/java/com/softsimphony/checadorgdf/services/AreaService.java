/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsimphony.checadorgdf.services;

import com.softsimphony.checadorgdf.dao.AreaMapper;
import com.softsimphony.checadorgdf.db.AccesoChecadorGDF_BD;
import com.softsimphony.checadorgdf.model.Area;
import com.softsimphony.checadorgdf.model.AreaExample;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author ss
 */
public class AreaService {
    private AreaMapper areaMapper;
    
    
    public List<Area> obtenerTodos() throws IOException{
        
        AreaExample areaExample = new AreaExample();
        areaExample.createCriteria().andIdAreaIsNotNull();
        return ejecutarExample(areaExample);
    }
    
    private List<Area> ejecutarExample(AreaExample areaExample) throws IOException{
        
        SqlSession session=null;
        try{
            session = AccesoChecadorGDF_BD.obtenerConexion();
            areaMapper = session.getMapper(AreaMapper.class);
            return areaMapper.selectByExample(areaExample);
            
        }finally{
            if(session != null)
                session.close();
        }   
    }
}
