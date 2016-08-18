/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsimphony.checadorgdf.db;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author ss
 */
public class AccesoChecadorGDF_BD {
    
    private static final String sourceDBSIAPPT="mybatis-config.xml";
    
    /**
     * Metodo que obtiene el objeto SqlSession para interactuar con la base de datos.
     * @return
     * @throws IOException 
     */
    public static SqlSession obtenerConexion() throws IOException{
        InputStream inputStream=Resources.getResourceAsStream(sourceDBSIAPPT);
            
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
        return sqlSessionFactory.openSession();
        
    }
    
}
