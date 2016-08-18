/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsimphony.checadorgdf.services;

import com.softsimphony.checadorgdf.dao.ReporteMapper;
import com.softsimphony.checadorgdf.db.AccesoChecadorGDF_BD;
import com.softsimphony.checadorgdf.model.ReporteExample;
import com.softsimphony.checadorgdf.model.Reporte;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author ss
 */
public class ReporteService {
    
    private ReporteMapper reporteMapper;
    
    public Reporte obtener(int idReporte) throws IOException{
        
        SqlSession session=null;
        try{
            session = AccesoChecadorGDF_BD.obtenerConexion();
            reporteMapper = session.getMapper(ReporteMapper.class);
            return reporteMapper.selectByPrimaryKey(idReporte);
        }finally{
            if(session != null)
                session.close();
        }
    }
    
    /**
     * Metodo para insertar un registro en la tabla Reporte de la base de datos
     * @param reporte 
     */
    public int insertar(Reporte reporte) throws IOException{
        
        SqlSession session=null;
        try{
            session = AccesoChecadorGDF_BD.obtenerConexion();
            reporteMapper = session.getMapper(ReporteMapper.class);
            reporteMapper.insert(reporte);
            session.commit();
            return reporte.getIdReporte();
        }finally{
            if(session != null)
                session.close();
        }
    }
    
    /**
     * Actualiza un registro de la tabla reporte apartir del idReporte
     * @param reporte 
     */
    public void actualizar(Reporte reporte) throws IOException{
        
        SqlSession session=null;
        try{
            session = AccesoChecadorGDF_BD.obtenerConexion();
            reporteMapper = session.getMapper(ReporteMapper.class);
            reporteMapper.updateByPrimaryKey(reporte);
            session.commit();
        }finally{
            if(session != null)
                session.close();
        }
        
    }
    
    public void eliminar(int idReporte) throws IOException{
        SqlSession session=null;
        try{
            session = AccesoChecadorGDF_BD.obtenerConexion();
            reporteMapper = session.getMapper(ReporteMapper.class);
            reporteMapper.deleteByPrimaryKey(idReporte);
            session.commit();
        }finally{
            if(session != null)
                session.close();
        }
    }
    
    public List<Reporte> obtenerTodos() throws IOException{
        
        ReporteExample reporteExample = new ReporteExample();
        reporteExample.createCriteria().andIdReporteIsNotNull();
        return ejecutarExample(reporteExample);
    }
    
    private List<Reporte> ejecutarExample(ReporteExample reporteExample) throws IOException{
        
        SqlSession session=null;
        
        try{
            
            session = AccesoChecadorGDF_BD.obtenerConexion();
            reporteMapper = session.getMapper(ReporteMapper.class);
            return reporteMapper.selectByExample(reporteExample);
            
        }finally{
            if(session != null)
                session.close();
        }
        
    }
    
}
