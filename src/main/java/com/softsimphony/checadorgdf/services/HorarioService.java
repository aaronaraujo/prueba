/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsimphony.checadorgdf.services;

import com.softsimphony.checadorgdf.dao.HorarioMapper;
import com.softsimphony.checadorgdf.db.AccesoChecadorGDF_BD;
import com.softsimphony.checadorgdf.model.Horario;
import com.softsimphony.checadorgdf.model.HorarioExample;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author ss
 */
public class HorarioService {
    
    private HorarioMapper horarioMapper;
    
    
    public List<Horario> obtenerTodos() throws IOException{
        
        HorarioExample horarioExample = new HorarioExample();
        horarioExample.createCriteria().andIdHorarioIsNotNull();
        return ejecutarExample(horarioExample);
    }
    
    private List<Horario> ejecutarExample(HorarioExample horarioExample) throws IOException{
        
        SqlSession session=null;
        
        try{
            
            session = AccesoChecadorGDF_BD.obtenerConexion();
            horarioMapper = session.getMapper(HorarioMapper.class);
            return horarioMapper.selectByExample(horarioExample);
            
        }finally{
            if(session != null)
                session.close();
        }
        
    }
    
    
    
}
