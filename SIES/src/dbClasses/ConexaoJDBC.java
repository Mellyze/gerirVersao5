/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public  class ConexaoJDBC extends ExecutaQuery {
    
   
    protected String url;
    protected String usuario;
    protected String senha;
    protected String database;
    public Connection con;
    public ResultSet rs;

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
    
    

    public String getSenha() {
        return senha;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }
    
    
    public void setPro()
    {
        Properties propriedades = new Properties();
        propriedades.setProperty("jdbc.user","us_desenvolvimento");
        propriedades.setProperty("jdbc.passwd","12345");
        propriedades.setProperty("jdbc.url", "jdbc:postgresql://localhost:5432");
        propriedades.setProperty("jdbc.banco", "db_veiculo");
        propriedades.setProperty("jdbc.statement", "org.postgresql.jdbc");
        try{
            FileOutputStream fi = new FileOutputStream("config.xml");
            propriedades.storeToXML(fi, "FILE JDBC PROPERTIES:","ISO-8859-1");
            fi.close();
        }
        catch(IOException e) {
           JOptionPane.showMessageDialog(null,"Erro no Banco");
        }
        
    }
    
    public void getProperties()
        {
            Properties propriedade = new Properties();
            try{
                FileInputStream file = new FileInputStream("config.xml");
                propriedade.loadFromXML(file);
            }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }
            this.setSenha(propriedade.getProperty("jdbc.passwd"));
            this.setUsuario(propriedade.getProperty("jdbc.user"));
            this.setUrl(propriedade.getProperty("jdbc.url"));
            this.setDatabase(propriedade.getProperty("jdbc.banco"));    
        }
    
    /**
     *
     * @return
     */
    public void conecta() {
            Connection con =null;
            try{
                
                ConexaoJDBC jdbc = new ConexaoJDBC();
                jdbc.getProperties();
                if (jdbc.getUrl()==null)
                {
                    jdbc.setPro();
                    jdbc.getProperties();
                }
                con = (Connection) DriverManager.getConnection(jdbc.getUrl()+"/"+jdbc.getDatabase(),jdbc.getUsuario(),jdbc.getSenha());
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Erro ao conectar no banco");
            }
            setCon(con);
        }
    
    public void disconecta() 
    {
        try{
            
                getCon().close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    public ResultSet executaSQL(String sql)
    {
        rs=executaSql(sql, con);
        return rs;
    }
    
    }
    
    


    
   
     
    
    
    
