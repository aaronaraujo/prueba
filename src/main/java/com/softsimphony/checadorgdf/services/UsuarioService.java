/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsimphony.checadorgdf.services;

import com.softsimphony.checadorgdf.dao.UsuarioMapper;
import com.softsimphony.checadorgdf.db.AccesoChecadorGDF_BD;
import com.softsimphony.checadorgdf.model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author ss
 */
public class UsuarioService {
    
    private UsuarioMapper usuarioMapper;
    
    public Usuario obtener(int idUsuario) throws IOException{
        
        SqlSession session=null;
        try{
            session = AccesoChecadorGDF_BD.obtenerConexion();
            usuarioMapper = session.getMapper(UsuarioMapper.class);
            return usuarioMapper.selectByPrimaryKey(idUsuario);
        }finally{
            if(session != null)
                session.close();
        }
    }
    
    /**
     * Metodo para insertar un registro en la tabla Usuario de la base de datos
     * @param usuario 
     */
    public int insertar(Usuario usuario) throws IOException{
        
        SqlSession session=null;
        try{
            session = AccesoChecadorGDF_BD.obtenerConexion();
            usuarioMapper = session.getMapper(UsuarioMapper.class);
            usuarioMapper.insert(usuario);
            session.commit();
            return usuario.getIdUsuario();
        }finally{
            if(session != null)
                session.close();
        }
    }
    
    /**
     * Actualiza un registro de la tabla usuario apartir del idUsuario
     * @param usuario 
     */
    public void actualizar(Usuario usuario) throws IOException{
        
        SqlSession session=null;
        try{
            session = AccesoChecadorGDF_BD.obtenerConexion();
            usuarioMapper = session.getMapper(UsuarioMapper.class);
            usuarioMapper.updateByPrimaryKey(usuario);
            session.commit();
        }finally{
            if(session != null)
                session.close();
        }
        
    }
    
    public void eliminar(int idUsuario) throws IOException{
        SqlSession session=null;
        try{
            session = AccesoChecadorGDF_BD.obtenerConexion();
            usuarioMapper = session.getMapper(UsuarioMapper.class);
            usuarioMapper.deleteByPrimaryKey(idUsuario);
            session.commit();
        }finally{
            if(session != null)
                session.close();
        }
    }
    
    
}
